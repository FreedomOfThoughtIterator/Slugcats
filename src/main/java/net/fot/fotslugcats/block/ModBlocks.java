package net.fot.fotslugcats.block;

import net.fot.fotslugcats.FoTSlugcats;
import net.fot.fotslugcats.block.custom.*;
import net.fot.fotslugcats.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(FoTSlugcats.MOD_ID);

    //PEBBLE FRUUIIIIIIIIIT
    public static final DeferredBlock<Block> PEBBLEFRUIT_VINE = registerBlock(
            "pebblefruit_vine",
            () -> new PebblefruitBlock(BlockBehaviour.Properties.of()
                    .instabreak()
                    //.requiresCorrectToolForDrops()
                    .sound(SoundType.CAVE_VINES)
                    .pushReaction(PushReaction.DESTROY)
                    .ignitedByLava()
                    .randomTicks()
                    .noCollission()
            ),
            false
    );

    public static final DeferredBlock<Block> PEBBLEFRUIT_PLANT_VINE = registerBlock(
            "pebblefruit_plant_vine",
            () -> new PebblefruitPlantBlock(BlockBehaviour.Properties.of()
                    .instabreak()
                    //.requiresCorrectToolForDrops()
                    .sound(SoundType.CAVE_VINES)
                    .pushReaction(PushReaction.DESTROY)
                    .ignitedByLava()
                    .randomTicks()
                    .noCollission()
            ),
            false
    );

    public static final DeferredBlock<Block> MOONFRUIT_VINE = registerBlock(
            "moonfruit_vine",
            () -> new MoonfruitBlock(BlockBehaviour.Properties.of()
                    .instabreak()
                    //.requiresCorrectToolForDrops()
                    .sound(SoundType.CAVE_VINES)
                    .pushReaction(PushReaction.DESTROY)
                    .ignitedByLava()
                    .randomTicks()
                    .noCollission()
            ),
            false
    );

    public static final DeferredBlock<Block> MOONFRUIT_PLANT_VINE = registerBlock(
            "moonfruit_plant_vine",
            () -> new MoonfruitPlantBlock(BlockBehaviour.Properties.of()
                    .instabreak()
                    //.requiresCorrectToolForDrops()
                    .sound(SoundType.CAVE_VINES)
                    .pushReaction(PushReaction.DESTROY)
                    .ignitedByLava()
                    .randomTicks()
                    .noCollission()
            ),
            false
    );

    public static final DeferredBlock<Block> FREEDOMFRUIT_VINE = registerBlock(
            "freedomfruit_vine",
            () -> new FreedomfruitBlock(BlockBehaviour.Properties.of()
                    .instabreak()
                    //.requiresCorrectToolForDrops()
                    .sound(SoundType.CAVE_VINES)
                    .pushReaction(PushReaction.DESTROY)
                    .ignitedByLava()
                    .randomTicks()
                    .noCollission()
            ),
            false
    );

    public static final DeferredBlock<Block> FREEDOMFRUIT_PLANT_VINE = registerBlock(
            "freedomfruit_plant_vine",
            () -> new FreedomfruitPlantBlock(BlockBehaviour.Properties.of()
                    .instabreak()
                    //.requiresCorrectToolForDrops()
                    .sound(SoundType.CAVE_VINES)
                    .pushReaction(PushReaction.DESTROY)
                    .ignitedByLava()
                    .randomTicks()
                    .noCollission()
            ),
            false
    );


    //Plants
    public static final DeferredBlock<Block> BLUEFRUIT_VINE = registerBlock(
            "bluefruit_vine",
            () -> new BluefruitVineBlock(BlockBehaviour.Properties.of()
                    .instabreak()
                    //.requiresCorrectToolForDrops()
                    .sound(SoundType.CAVE_VINES)
                    .pushReaction(PushReaction.DESTROY)
                    .ignitedByLava()
                    .randomTicks()
                    .noCollission()
            ),
            false
    );

    public static final DeferredBlock<Block> BLUEFRUIT_PLANT_VINE = registerBlock(
            "bluefruit_plant_vine",
            () -> new BluefruitPlantVineBlock(BlockBehaviour.Properties.of()
                    .instabreak()
                    //.requiresCorrectToolForDrops()
                    .sound(SoundType.CAVE_VINES)
                    .pushReaction(PushReaction.DESTROY)
                    .ignitedByLava()
                    .randomTicks()
                    .noCollission()
            ),
            false
    );

    public static final DeferredBlock<Block> DOUBLE_WORMGRASS = registerBlock(
            "double_wormgrass",
            () -> new DoubleWormgrassBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XYZ)
                    .ignitedByLava()
                    .pushReaction(PushReaction.DESTROY)
            ),
            true
    );

    public static final DeferredBlock<Block> WORMGRASS = registerBlock(
            "wormgrass",
            () -> new WormgrassBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true)
                    .lightLevel(state -> 2)
                    .offsetType(BlockBehaviour.OffsetType.XYZ)
                    .ignitedByLava()
                    .randomTicks()
                    .pushReaction(PushReaction.DESTROY)
            ),
            true
    );

    public static final DeferredBlock<Block> GENETICALLYMODIFIEDGRASS = registerBlock(
            "genetically_modified_grass",
            () -> new StronggrassBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XYZ)
                    .replaceable()
                    .ignitedByLava()
                    .pushReaction(PushReaction.DESTROY)
            ),
            true
    );

    public static final DeferredBlock<Block> GENETICALLYMODIFIEDWEEDS = registerBlock(
            "genetically_modified_weeds",
            () -> new StronggrassBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XYZ)
                    .replaceable()
                    .ignitedByLava()
                    .pushReaction(PushReaction.DESTROY)
            ),
            true
    );

    public static final DeferredBlock<Block> KARMAFLOWER = registerBlock(
            "karma_flower",
            () -> new FlowerBlock(
                    MobEffects.FIRE_RESISTANCE,
                    4.0F,
                    BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ)
                    .replaceable()
                    .ignitedByLava()
                    .pushReaction(PushReaction.DESTROY)
            ),
            false
    );

    //Poles
    public static final DeferredBlock<Block> POLE = registerBlock(
            "pole",
            () -> new PoleBlock(BlockBehaviour.Properties.of()
                    .sound(SoundType.STONE)
                    .strength(2.0F)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
            ),
            true
    );

    //Solid Blocks
    public static final DeferredBlock<Block> DARK_BRICKS = registerBlock(
            "dark_bricks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.STONE)
                    .strength(2.0F)
                    .requiresCorrectToolForDrops()
            ),
            true
    );

    public static final DeferredBlock<Block> ITER_STEEL = registerBlock(
            "iter_steel",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(-1, 1000000)
                    .sound(SoundType.METAL)
                    .pushReaction(PushReaction.IGNORE)
            ),
            true
    );

    public static final DeferredBlock<Block> ITER_STEEL_CLEAN = registerBlock(
            "clean_iter_steel",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(-1, 1000000)
                    .sound(SoundType.METAL)
                    .pushReaction(PushReaction.IGNORE)
            ),
            true
    );

    public static final DeferredBlock<Block> ITER_TILE = registerBlock(
            "iter_tile",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(-1, 1000000)
                    .sound(SoundType.METAL)
                    .pushReaction(PushReaction.IGNORE)
            ),
            true
    );

    public static final DeferredBlock<Block> TRUSS = registerBlock(
            "metallic_truss_small",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2, 100)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)
                    .noOcclusion()
                    .isViewBlocking(ModBlocks::never)
            ),
            true
    );

    public static final DeferredBlock<Block> VENTSMALL = registerBlock(
            "vent_duct_small",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .strength(2, 100)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)
                    .noOcclusion()
                    .isViewBlocking(ModBlocks::never)
            ),
            true
    );

    public static final DeferredBlock<Block> VENTCURVEDSMALL = registerBlock(
            "vent_curved_small",
            () -> new CurvedBlock(BlockBehaviour.Properties.of()
                    .strength(2, 100)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)
                    .noOcclusion()
                    .isViewBlocking(ModBlocks::never)
            ),
            true
    );

    public static final DeferredBlock<Block> VENTLARGE = registerBlock(
            "vent_duct_large",
            () -> new CurvedBlock(BlockBehaviour.Properties.of()
                    .strength(2, 100)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)
                    .noOcclusion()
                    .isViewBlocking(ModBlocks::never)
            ),
            true
    );

    public static final DeferredBlock<Block> VENTCURVEDLARGE = registerBlock(
            "vent_curved_large",
            () -> new VentCurvedBlock(BlockBehaviour.Properties.of()
                    .strength(2, 100)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)
                    .noOcclusion()
                    .isViewBlocking(ModBlocks::never)
            ),
            true
    );

    public static final DeferredBlock<Block> VENT_HUB_SMALL = registerBlock(
            "vent_hub_small",
            () -> new YAxisRotationBlock(BlockBehaviour.Properties.of()
                    .strength(2, 100)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)
            ),
            true
    );

    public static final DeferredBlock<Block> VENT_DUCT_BLOCK = registerBlock(
            "vent_duct_block",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .strength(2, 100)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)
            ),
            true
    );

    private static Boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, EntityType<?> entityType) {
        return false;
    }

    private static Boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return false;
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block, Boolean registerItem) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        if (registerItem) {
            registerBlockItem(name, toReturn);
        }
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
