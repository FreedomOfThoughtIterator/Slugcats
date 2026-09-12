package net.fot.fotslugcats.block.custom;

import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class VentCurvedBlock extends CurvedBlock {
    private final ImmutableMap<BlockState, VoxelShape> shapes = this.makeShapes();


    public VentCurvedBlock(Properties properties) {
        super(properties);
    }

    private ImmutableMap<BlockState, VoxelShape> makeShapes() {
        return this.getShapeForEachState(state -> {
            return switch (state.getValue(FACING)) {
                case NORTH -> switch (state.getValue(FACE)) {
                    case FLOOR -> box(8, 0, 8, 16, 16, 16);
                    case WALL -> box(8, 8, 0, 16, 16, 16);
                    case CEILING -> box(0, 0, 8, 8, 16, 16);
                };
                case EAST -> switch (state.getValue(FACE)) {
                    case FLOOR -> box(0, 0, 8, 8, 16, 16);
                    case WALL -> box(0, 8, 8, 16, 16, 16);
                    case CEILING -> box(0, 0, 0, 8, 16, 8);
                };
                case WEST -> switch (state.getValue(FACE)) {
                    case FLOOR -> box(8, 0, 0, 16, 16, 8);
                    case WALL -> box(0, 8, 0, 16, 16, 8);
                    case CEILING -> box(8, 0, 8, 16, 16, 16);
                };
                default -> switch (state.getValue(FACE)) {
                    case FLOOR -> box(0, 0, 0, 8, 16, 8);
                    case WALL -> box(0, 8, 0, 8, 16, 16);
                    case CEILING -> box(8, 0, 0, 16, 16, 8);
                };
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
