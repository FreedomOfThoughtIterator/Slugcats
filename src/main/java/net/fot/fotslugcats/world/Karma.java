package net.fot.fotslugcats.world;

import net.fot.fotslugcats.FoTSlugcats;
import net.fot.fotslugcats.attributes.ModAttributes;
import net.fot.fotslugcats.item.ModItems;
import net.fot.fotslugcats.screen.custom.KarmaMenu;
import net.fot.fotslugcats.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.entity.player.PlayerWakeUpEvent;
import net.neoforged.neoforge.items.ItemHandlerHelper;

@EventBusSubscriber
public class Karma {

    public static void RaiseKarma(LivingEntity entity) {
        if (entity.getAttribute(ModAttributes.KARMA).getBaseValue() < entity.getAttribute(ModAttributes.MAX_KARMA).getBaseValue()) {
            entity.getAttribute(ModAttributes.KARMA).setBaseValue(entity.getAttribute(ModAttributes.KARMA).getValue() + 1);
        }
    }

    public static void LowerKarma(LivingEntity entity) {
        if (entity.getAttribute(ModAttributes.KARMA).getBaseValue() > 1.0) {
            entity.getAttribute(ModAttributes.KARMA).setBaseValue(entity.getAttribute(ModAttributes.KARMA).getValue() - 1);
        }
    }

    public static void PlaySound(Level level, SoundEvent soundEvent, Double x, Double y, Double z) {
        if (!level.isClientSide()) {
            level.playSound(null, BlockPos.containing(x, y, z), soundEvent, SoundSource.PLAYERS, 1, 1);
        } else {
            level.playLocalSound(x, y, z, soundEvent, SoundSource.PLAYERS, 1, 1, false);
        }
    }

    @SubscribeEvent
    public static void onEntityEndSleep(PlayerWakeUpEvent event) {
        LivingEntity entity = event.getEntity();
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        Level level = entity.level();

        if (entity.getPersistentData().getDouble("SleepTimer") == 0) {
            PlaySound(level, ModSounds.KarmaIncGUIOpen.get(), x, y, z);


            if (entity instanceof ServerPlayer SEntity) {
                SEntity.openMenu(new SimpleMenuProvider(
                        (containerId, playerInventory, player) -> new
                                KarmaMenu(containerId, playerInventory),
                        Component.translatable("menu.title.examplemod.mymenu")
                ));
            }

            FoTSlugcats.queueServerWork(30, () -> {
                PlaySound(level, ModSounds.KarmaChg.get(), x, y, z);
                FoTSlugcats.queueServerWork(20, () -> {
                    PlaySound(level, ModSounds.KarmaInc.get(), x, y, z);
                    RaiseKarma(entity);
                });
            });
            FoTSlugcats.queueServerWork(80, () -> {
                Player player = (Player) entity;
                player.closeContainer();
                if (Math.random() <= 0.1) {
                    ItemStack banilla = new ItemStack(ModItems.BANILLA.get()).copy();
                    banilla.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer((Player) entity, banilla);
                }
            });
        }
    }

    @SubscribeEvent
    public static void onPlayerDeath(PlayerEvent.PlayerRespawnEvent event) {
        LivingEntity entity = event.getEntity();
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        Level level = entity.level();

        PlaySound(level, ModSounds.KarmaDecGUIOpen.get(), x, y, z);

        if (entity instanceof ServerPlayer SEntity) {
            SEntity.openMenu(new SimpleMenuProvider(
                    (containerId, playerInventory, player) -> new
                            KarmaMenu(containerId, playerInventory),
                    Component.translatable("menu.title.examplemod.mymenu")
            ));
        }

        FoTSlugcats.queueServerWork(30, () -> {
            PlaySound(level, ModSounds.KarmaChg.get(), x, y, z);
            FoTSlugcats.queueServerWork(20, () -> {
                LowerKarma(entity);
                PlaySound(level, ModSounds.KarmaIncGUIOpen.get(), x, y, z);
            });
        });
    }
}