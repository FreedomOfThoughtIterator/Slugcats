package net.fot.fotslugcats.datagen;

import net.fot.fotslugcats.FoTSlugcats;
import net.fot.fotslugcats.item.ModItems;
import net.fot.fotslugcats.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, FoTSlugcats.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.SLUG_FOOD)
                .add(ModItems.BLUEFRUIT.get())
                .add(ModItems.PEBBLEFRUIT.get())
                .add(ModItems.FREEDOMFRUIT.get())
                .add(ModItems.MOONFRUIT.get())
                .add(Items.PORKCHOP)
                .add(Items.BEEF)
                .add(Items.CHICKEN)
                .add(Items.MUTTON)
                .add(Items.RABBIT)
                .add(Items.WHEAT)
                .add(Items.CARROT)
                .add(Items.BEETROOT)
                .add(Items.POTATO)
                .add(Items.APPLE);
    }
}
