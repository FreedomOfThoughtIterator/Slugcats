package net.fot.fotslugcats.block.custom;

import com.mojang.serialization.MapCodec;
import net.fot.fotslugcats.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WormgrassBlock extends BushBlock implements BonemealableBlock {
    public static final MapCodec<WormgrassBlock> CODEC = simpleCodec(WormgrassBlock::new);
    protected static final float AABB_OFFSET = 6.0F;
    protected static final VoxelShape SHAPE = Block.box(2.0, 0.0, 2.0, 14.0, 13.0, 14.0);

    @Override
    public MapCodec<WormgrassBlock> codec() {
        return CODEC;
    }

    public WormgrassBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity) {

        if (entity instanceof LivingEntity entity1 && !(entity instanceof ItemEntity)) {
            entity1.hurt(new DamageSource(level.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("fotslugcats:wormgrass_eat")))), 2.0F);

            if (!entity1.level().isClientSide()) {
                entity1.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1, 2, false, false));
            }
        }

        super.entityInside(blockState, level, blockPos, entity);
    }

    @Override
    protected void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if (serverLevel.getMaxLocalRawBrightness(blockPos.above()) >= 9) {
            BlockState blockState2 = this.defaultBlockState();

            for (int i = 0; i < 4; i++) {
                BlockPos blockPos2 = blockPos.offset(randomSource.nextInt(3) - 1, randomSource.nextInt(5) - 3, randomSource.nextInt(3) - 1);
                if (serverLevel.getBlockState(blockPos2).is(Blocks.SHORT_GRASS)) {
                    serverLevel.setBlockAndUpdate(
                            blockPos2, (BlockState)blockState2
                    );
                }
            }
        }
    }

    @Override
    protected VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(BlockTags.DIRT) || state.is(BlockTags.BASE_STONE_NETHER) || state.is(BlockTags.BASE_STONE_OVERWORLD);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        DoublePlantBlock doublePlantBlock = (DoublePlantBlock)(blockState.is(Blocks.FERN) ? Blocks.LARGE_FERN : ModBlocks.DOUBLE_WORMGRASS.get());
        if (doublePlantBlock.defaultBlockState().canSurvive(serverLevel, blockPos) && serverLevel.isEmptyBlock(blockPos.above())) {
            DoublePlantBlock.placeAt(serverLevel, doublePlantBlock.defaultBlockState(), blockPos, 2);
        }
    }

    @Override
    public Type getType() {
        return Type.NEIGHBOR_SPREADER;
    }
}
