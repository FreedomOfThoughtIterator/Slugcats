package net.fot.fotslugcats.world;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.profiling.jfr.event.WorldLoadFinishedEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

@EventBusSubscriber
public class DeadlyRain {
    public static int PrevDamageTick = 0;
    public static int CurrentDamageTick = 0;

    @SubscribeEvent
    public static void normalRainDisable(PlayerEvent.PlayerLoggedInEvent event) {
        Level level = event.getEntity().level();
        double x = event.getEntity().getX();
        double y = event.getEntity().getY();
        double z = event.getEntity().getZ();
        if (level.getGameRules().getBoolean(GameRules.RULE_WEATHER_CYCLE)) {
            if (level instanceof ServerLevel) {
                level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, (ServerLevel) level, 4, "", Component.literal(""), level.getServer(), null).withSuppressedOutput(),
                        "gamerule doWeatherCycle false");
                level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, (ServerLevel) level, 4, "", Component.literal(""), level.getServer(), null).withSuppressedOutput(),
                        "weather clear");
            }
        }
    }

    @SubscribeEvent
    public static void rainDamage(EntityTickEvent.Post event) {
        Entity entity = event.getEntity();
        Level level = event.getEntity().level();
        double y = entity.getY();
        float biomeTemperature = level.getBiome(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).value().getBaseTemperature();

        if (entity instanceof LivingEntity) {
            damage(entity, level, y, biomeTemperature);
        } else if (entity instanceof Player) {
            damage(entity, level, y, biomeTemperature);
        }
    }

    private static void damage(Entity entity, Level level, double y, float biomeTemperature) {
        if (level instanceof ServerLevel && level.isRaining() && -40 < y && y < 191) {
            CurrentDamageTick = level.getServer().getTickCount() / 10;
            if (CurrentDamageTick > PrevDamageTick && 0.4f < biomeTemperature && biomeTemperature < 1.6) {
                int damage = Mth.ceil((191 - y) / 38.2);
                entity.hurt(new DamageSource(level.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("fotslugcats:rain_crush")))), damage);
                System.out.println(level.getServer().getTickCount());
            }
            PrevDamageTick = CurrentDamageTick;
        }
    }
}
