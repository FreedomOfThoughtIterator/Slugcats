package net.fot.fotslugcats.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class KarmaFlowerItem extends BlockItem {
    public KarmaFlowerItem(Block block, Item.Properties properties) {
        super(block, properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        if (level instanceof ServerLevel _level) {
            _level.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Karma"), false);

        }
        return super.finishUsingItem(itemStack, level, livingEntity);
    }

    public String getDescriptionId() {
        return this.getOrCreateDescriptionId();
    }
}
