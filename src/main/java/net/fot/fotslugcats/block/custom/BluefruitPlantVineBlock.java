package net.fot.fotslugcats.block.custom;

import com.mojang.serialization.MapCodec;
import net.fot.fotslugcats.block.ModBlocks;
import net.fot.fotslugcats.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;

public class BluefruitPlantVineBlock extends GrowingPlantBodyBlock implements BluefruitVines {
    public static final MapCodec<BluefruitPlantVineBlock> CODEC = simpleCodec(BluefruitPlantVineBlock::new);

    @Override
    public MapCodec<BluefruitPlantVineBlock> codec() {
        return CODEC;
    }

    public BluefruitPlantVineBlock(Properties properties) {
        super(properties, Direction.DOWN, SHAPE, false);
    }

    @Override
    protected GrowingPlantHeadBlock getHeadBlock() {
        return (GrowingPlantHeadBlock)ModBlocks.BLUEFRUIT_VINE.get();
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
        return new ItemStack(ModItems.BLUEFRUIT.get());
    }
}
