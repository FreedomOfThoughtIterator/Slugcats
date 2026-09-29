package net.fot.fotslugcats.datagen;

import net.fot.fotslugcats.FoTSlugcats;
import net.fot.fotslugcats.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FoTSlugcats.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.CLIMBABLE)
                .add(ModBlocks.BLUEFRUIT_VINE.get())
                .add(ModBlocks.BLUEFRUIT_PLANT_VINE.get())
                .add(ModBlocks.PEBBLEFRUIT_VINE.get())
                .add(ModBlocks.PEBBLEFRUIT_PLANT_VINE.get())
                .add(ModBlocks.MOONFRUIT_VINE.get())
                .add(ModBlocks.MOONFRUIT_PLANT_VINE.get())
                .add(ModBlocks.FREEDOMFRUIT_VINE.get())
                .add(ModBlocks.FREEDOMFRUIT_PLANT_VINE.get())
                .add(ModBlocks.POLE.get())
                .add(ModBlocks.POLECORNER.get())
                .add(ModBlocks.POLECORNERJUNC.get())
                .add(ModBlocks.POLEIJUNC.get())
                .add(ModBlocks.POLETJUNC.get())
                .add(ModBlocks.POLEPLUSJUNC.get())
        ;

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.POLE.get())
                .add(ModBlocks.POLECORNER.get())
                .add(ModBlocks.POLECORNERJUNC.get())
                .add(ModBlocks.POLEIJUNC.get())
                .add(ModBlocks.POLETJUNC.get())
                .add(ModBlocks.POLEPLUSJUNC.get())
                .add(ModBlocks.DARK_BRICKS.get())
                .add(ModBlocks.DARK_ROCK.get())
                .add(ModBlocks.PANEL.get())
                .add(ModBlocks.TRUSS.get())

        ;

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.POLE.get())
                .add(ModBlocks.POLECORNER.get())
                .add(ModBlocks.POLECORNERJUNC.get())
                .add(ModBlocks.POLEIJUNC.get())
                .add(ModBlocks.POLETJUNC.get())
                .add(ModBlocks.POLEPLUSJUNC.get())
        ;

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.PANEL.get())
                .add(ModBlocks.TRUSS.get())
        ;
    }
}
