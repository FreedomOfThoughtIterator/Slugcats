package net.fot.fotslugcats.block.custom;

import com.mojang.serialization.MapCodec;
import net.fot.fotslugcats.block.ModBlocks;
import net.fot.fotslugcats.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.CommonHooks;

import javax.annotation.Nullable;

public class BluefruitVineBlock extends GrowingPlantHeadBlock implements IteratorfruitVines{
    public static final MapCodec<BluefruitVineBlock> CODEC = simpleCodec(BluefruitVineBlock::new);
    private static final float CHANCE_OF_BLUEFRUIT_GROWTH = 0.11F;

    @Override
    protected MapCodec<? extends GrowingPlantHeadBlock> codec() {
        return CODEC;
    }

    public BluefruitVineBlock(Properties properties) {
        super(properties, Direction.DOWN, SHAPE, false, 0.1);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0).setValue(FRUIT, false));
    }

    @Override
    protected int getBlocksToGrowWhenBonemealed(RandomSource randomSource) {
        return 1;
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!state.getValue(FRUIT)) {
            if ((Integer) state.getValue(AGE) < 25 && CommonHooks.canCropGrow(level, pos.relative(this.growthDirection), state, random.nextDouble() < 0.2)) {
                BlockPos blockpos = pos.relative(this.growthDirection);
                if (this.canGrowInto(level.getBlockState(blockpos))) {
                    level.setBlockAndUpdate(blockpos, this.getGrowIntoState(state, level.random));
                    CommonHooks.fireCropGrowPost(level, blockpos, level.getBlockState(blockpos));
                }
            }
        }

    }

    @Override
    protected boolean canGrowInto(BlockState blockState) {
        return blockState.isAir();
    }

    @Override
    protected Block getBodyBlock() {
        return ModBlocks.BLUEFRUIT_PLANT_VINE.get();
    }

    @Override
    protected BlockState getGrowIntoState(BlockState blockState, RandomSource randomSource) {
        return super.getGrowIntoState(blockState, randomSource).setValue(FRUIT, randomSource.nextFloat() < 0.33F);
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
        return new ItemStack(ModItems.BLUEFRUIT.get());
    }

    protected InteractionResult useWithoutItem(BlockState blockState, Level level, BlockPos blockPos, Player player, BlockHitResult blockHitResult) {
        return IteratorfruitVines.use(player, blockState, level, blockPos, ModItems.BLUEFRUIT.get());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FRUIT);
    }
}
