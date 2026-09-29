package net.fot.fotslugcats.block.custom;

import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PoleIJunctionBlock extends Block {
    public static final DirectionProperty FACING = DirectionalBlock.FACING;
    private final ImmutableMap<BlockState, VoxelShape> shapes = this.makeShapes();

    public PoleIJunctionBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    private ImmutableMap<BlockState, VoxelShape> makeShapes() {
        return this.getShapeForEachState(state -> {
            return switch (state.getValue(FACING)) {
                case NORTH -> Shapes.or(box(7, 0, 7, 9, 16, 9), box(7, 7, 0, 9, 9, 7), box(0, 7, 7, 7, 9, 9));
                case EAST -> Shapes.or(box(7, 0, 7, 9, 16, 9), box(9, 7, 7, 16, 9, 9), box(7, 7, 0, 9, 9, 7));
                case WEST -> Shapes.or(box(7, 0, 7, 9, 16, 9), box(0, 7, 7, 7, 9, 9), box(7, 7, 9, 9, 9, 16));
                case UP -> Shapes.or(box(7, 7, 0, 9, 9, 16), box(7, 9, 7, 9, 16, 9), box(0, 7, 7, 7, 9, 9));
                case DOWN -> Shapes.or(box(7, 7, 0, 9, 9, 16), box(7, 0, 7, 9, 7, 9), box(0, 7, 7, 7, 9, 9));
                default -> Shapes.or(box(7, 0, 7, 9, 16, 9), box(7, 7, 9, 9, 9, 16), box(9, 7, 7, 16, 9, 9));
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
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = super.getStateForPlacement(context);
        if (state == null)
            return null;
        return state.setValue(FACING, context.getNearestLookingDirection().getOpposite());
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
