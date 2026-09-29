package net.fot.fotslugcats.block.custom;

import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PoleCornerBlock extends Block {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final EnumProperty<AttachFace> FACE = FaceAttachedHorizontalDirectionalBlock.FACE;
    private final ImmutableMap<BlockState, VoxelShape> shapes = this.makeShapes();

    public PoleCornerBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    private ImmutableMap<BlockState, VoxelShape> makeShapes() {
        return this.getShapeForEachState(state -> {
            return switch (state.getValue(FACING)) {
                case NORTH -> switch (state.getValue(FACE)) {
                    case FLOOR -> Shapes.or(box(7, 0, 7, 9, 16, 9), box(7, 7, 0, 9, 9, 7));
                    case WALL -> Shapes.or(box(7, 7, 0, 9, 9, 16), box(7, 0, 7, 9, 7, 9));
                    case CEILING -> Shapes.or(box(7, 0, 7, 9, 16, 9), box(7, 7, 0, 9, 9, 7));
                };
                case EAST -> switch (state.getValue(FACE)) {
                    case FLOOR -> Shapes.or(box(7, 0, 7, 9, 16, 9), box(9, 7, 7, 16, 9, 9));
                    case WALL -> Shapes.or(box(0, 7, 7, 16, 9, 9), box(7, 0, 7, 9, 7, 9));
                    case CEILING -> Shapes.or(box(7, 0, 7, 9, 16, 9), box(9, 7, 7, 16, 9, 9));
                };
                case WEST -> switch (state.getValue(FACE)) {
                    case FLOOR -> Shapes.or(box(7, 0, 7, 9, 16, 9), box(0, 7, 7, 7, 9, 9));
                    case WALL -> Shapes.or(box(0, 7, 7, 16, 9, 9), box(7, 0, 7, 9, 7, 9));
                    case CEILING -> Shapes.or(box(7, 0, 7, 9, 16, 9), box(0, 7, 7, 7, 9, 9));
                };
                default -> switch (state.getValue(FACE)) {
                    case FLOOR -> Shapes.or(box(7, 0, 7, 9, 16, 9), box(7, 7, 9, 9, 9, 16));
                    case WALL -> Shapes.or(box(7, 7, 0, 9, 9, 16), box(7, 0, 7, 9, 7, 9));
                    case CEILING -> Shapes.or(box(7, 0, 7, 9, 16, 9), box(7, 7, 9, 9, 9, 16));
                };
            };
        });
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return shapes.get(state);
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
        return state.getFluidState().isEmpty();
    }

    @Override
    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return propagatesSkylightDown(state, worldIn, pos) ? 0 : 1;
    }

    @Override
    public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING, FACE);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = super.getStateForPlacement(context);
        if (state == null)
            return null;
        return state.setValue(FACE, faceForDirection(context.getNearestLookingDirection())).setValue(FACING, context.getNearestLookingDirection().getOpposite());
    }

    private AttachFace faceForDirection(Direction direction) {
        if (direction.getAxis() == Direction.Axis.Y)
            return direction == Direction.UP ? AttachFace.CEILING : AttachFace.FLOOR;
        else
            return AttachFace.WALL;
    }

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
        return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
    }

    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }

}
