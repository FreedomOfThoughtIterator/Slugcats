package net.fot.fotslugcats.block.custom;

import net.fot.fotslugcats.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public interface BluefruitVines {
    VoxelShape SHAPE = Block.box(1.0, 0.0, 1.0, 15.0, 16.0, 15.0);
    BooleanProperty FRUIT = BlockStateProperties.BERRIES;

    static InteractionResult use(@Nullable Entity entity, BlockState blockState, Level level, BlockPos blockPos) {
        if ((Boolean)blockState.getValue(FRUIT)) {
            Block.popResource(level, blockPos, new ItemStack(ModItems.BLUEFRUIT.get(), 1));
            float f = Mth.randomBetween(level.random, 0.8F, 1.2F);
            level.playSound((Player)null, blockPos, SoundEvents.CAVE_VINES_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, f);
            BlockState blockState2 = blockState.setValue(FRUIT, false);
            level.setBlock(blockPos, blockState2, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(entity, blockState2));
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return InteractionResult.PASS;
        }
    }

    static boolean hasBluefruit(BlockState blockState) {
        return blockState.hasProperty(FRUIT) && (Boolean)blockState.getValue(FRUIT);
    }
}
