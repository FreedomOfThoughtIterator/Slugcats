package net.fot.fotslugcats.datagen;

import net.fot.fotslugcats.block.ModBlocks;
import net.fot.fotslugcats.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CaveVines;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider( HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        add(ModBlocks.PEBBLEFRUIT_VINE.get(),
                block -> createIteratorFruitDrop(ModBlocks.PEBBLEFRUIT_VINE.get(), ModItems.PEBBLEFRUIT.get())
        );
        add(ModBlocks.MOONFRUIT_VINE.get(),
                block -> createIteratorFruitDrop(ModBlocks.MOONFRUIT_VINE.get(), ModItems.MOONFRUIT.get())
        );
        add(ModBlocks.FREEDOMFRUIT_VINE.get(),
                block -> createIteratorFruitDrop(ModBlocks.FREEDOMFRUIT_VINE.get(), ModItems.FREEDOMFRUIT.get())
        );
        add(ModBlocks.BLUEFRUIT_VINE.get(),
                block -> createIteratorFruitDrop(ModBlocks.BLUEFRUIT_VINE.get(), ModItems.BLUEFRUIT.get())
        );
        add(ModBlocks.DOUBLE_WORMGRASS.get(),
                block -> createOreDrop(ModBlocks.DOUBLE_WORMGRASS.get(), ModBlocks.WORMGRASS.asItem())
        );
        dropSelf(ModBlocks.WORMGRASS.get());
        dropSelf(ModBlocks.KARMAFLOWER.get());
        dropSelf(ModBlocks.POLE.get());
        dropSelf(ModBlocks.POLECORNER.get());
        dropSelf(ModBlocks.POLECORNERJUNC.get());
        dropSelf(ModBlocks.POLEIJUNC.get());
        dropSelf(ModBlocks.POLEPLUSJUNC.get());
        dropSelf(ModBlocks.POLETJUNC.get());
        dropSelf(ModBlocks.DARK_BRICKS.get());
        add(ModBlocks.DARK_ROCK.get(),
                block -> createOreDrop(ModBlocks.DARK_ROCK.get(), Blocks.COBBLESTONE.asItem())
        );
        dropSelf(ModBlocks.TRUSS.get());
        dropSelf(ModBlocks.VENTSMALL.get());
        dropSelf(ModBlocks.VENTCURVEDSMALL.get());
        dropSelf(ModBlocks.VENTLARGE.get());
        dropSelf(ModBlocks.VENTCURVEDLARGE.get());
        dropSelf(ModBlocks.ITER_COMP_BLUE.get());
        dropSelf(ModBlocks.ITER_COMP_RED.get());
        dropSelf(ModBlocks.METAL_PLATE.get());
        dropSelf(ModBlocks.PANEL.get());
        dropSelf(ModBlocks.VENT_HUB_SMALL.get());
        dropSelf(ModBlocks.VENT_DUCT_BLOCK.get());
        dropSelf(ModBlocks.KARMA_LAMP_1.get());
        dropSelf(ModBlocks.KARMA_LAMP_2.get());
        dropSelf(ModBlocks.KARMA_LAMP_3.get());
        dropSelf(ModBlocks.KARMA_LAMP_4.get());
        dropSelf(ModBlocks.KARMA_LAMP_5.get());
        dropSelf(ModBlocks.KARMA_LAMP_6.get());
        dropSelf(ModBlocks.KARMA_LAMP_7.get());
        dropSelf(ModBlocks.KARMA_LAMP_8.get());
        dropSelf(ModBlocks.KARMA_LAMP_9.get());
        dropSelf(ModBlocks.KARMA_LAMP_10.get());

    }

    protected LootTable.Builder createIteratorFruitDrop(Block block, Item item) {
        return LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(item)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(net.minecraft.advancements.critereon.StatePropertiesPredicate.Builder.properties().hasProperty(CaveVines.BERRIES, true))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
