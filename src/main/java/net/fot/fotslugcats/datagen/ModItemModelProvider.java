package net.fot.fotslugcats.datagen;

import net.fot.fotslugcats.FoTSlugcats;
import net.fot.fotslugcats.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FoTSlugcats.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.BLUEFRUIT.get());
        basicItem(ModItems.FREEDOMFRUIT.get());
        basicItem(ModItems.PEBBLEFRUIT.get());
        basicItem(ModItems.MOONFRUIT.get());
        basicItem(ModItems.BANILLA.get());
        basicItem(ModItems.KARMA_FLOWER.get());
        basicItem(ModItems.KARMIC_ESSENCE.get());
        basicItem(ModItems.DATAPEARL.get());
    }
}
