package net.fot.fotslugcats.datagen;

import net.fot.fotslugcats.FoTSlugcats;
import net.fot.fotslugcats.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FoTSlugcats.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        BlockWithItem(ModBlocks.ITER_STEEL_CLEAN);
        BlockWithItem(ModBlocks.ITER_STEEL);
        BlockWithItem(ModBlocks.ITER_LATTICE);
        BlockWithItem(ModBlocks.ITER_TILE);
        BlockWithItem(ModBlocks.DARK_BRICKS);
        BlockWithItem(ModBlocks.DARK_ROCK);
        BlockWithItem(ModBlocks.METAL_PLATE);
        BlockWithItem(ModBlocks.PANEL);
        BlockWithItem(ModBlocks.DATAPEARL_READER);

    }

    private void BlockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

}
