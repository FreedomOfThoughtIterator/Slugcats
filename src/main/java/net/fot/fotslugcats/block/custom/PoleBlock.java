package net.fot.fotslugcats.block.custom;

import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PoleBlock extends RotatedPillarBlock {
    private final ImmutableMap<BlockState, VoxelShape> shapes = this.makeShapes();
    public PoleBlock(Properties properties) {
        super(properties);
    }

    private ImmutableMap<BlockState, VoxelShape> makeShapes() {
        return this.getShapeForEachState(state -> {
            return switch (state.getValue(AXIS)) {
                case X -> box(0, 7, 7, 16, 9, 9);
                case Y -> box(7, 0, 7, 9, 16, 9);
                case Z -> box(7, 7, 0, 9, 9, 16);
            };
        });
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return shapes.get(state);
    }

    @Override
    public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }
}
