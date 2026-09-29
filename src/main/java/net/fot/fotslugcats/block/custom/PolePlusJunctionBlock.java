package net.fot.fotslugcats.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PolePlusJunctionBlock extends Block {
    private static final VoxelShape SHAPE = Shapes.or(box(7, 0, 7, 9, 16, 9), box(7, 7, 0, 9, 9, 7), box(7, 7, 9, 9, 9, 16), box(0, 7, 7, 7, 9, 9), box(9, 7, 7, 16, 9, 9));

    public PolePlusJunctionBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

}
