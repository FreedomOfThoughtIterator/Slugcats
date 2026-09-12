package net.fot.fotslugcats.block.custom;

import com.mojang.serialization.MapCodec;
import net.fot.fotslugcats.block.ModBlocks;
import net.fot.fotslugcats.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class FreedomfruitBlock extends BluefruitVineBlock implements IteratorfruitVines {
    public static final MapCodec<FreedomfruitBlock> CODEC = simpleCodec(FreedomfruitBlock::new);

    public FreedomfruitBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected Block getBodyBlock() {
        return ModBlocks.FREEDOMFRUIT_PLANT_VINE.get();
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
        return new ItemStack(ModItems.FREEDOMFRUIT.get());
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState blockState, Level level, BlockPos blockPos, Player player, BlockHitResult blockHitResult) {
        return IteratorfruitVines.use(player, blockState, level, blockPos, ModItems.FREEDOMFRUIT.get());
    }
}
