package net.fot.fotslugcats.datagen;

import net.fot.fotslugcats.block.ModBlocks;
import net.fot.fotslugcats.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> KARMA_E_SMELTABLES = List.of(ModItems.KARMA_FLOWER

    );

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.KARMA_LAMP_1)
                .requires(Blocks.REDSTONE_LAMP)
                .requires(ModItems.KARMIC_ESSENCE.get())
                .unlockedBy("has_essence", has(ModItems.KARMIC_ESSENCE.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.KARMA_LAMP_2)
                .requires(Blocks.REDSTONE_LAMP, 1)
                .requires(ModItems.KARMIC_ESSENCE.get(), 2)
                .unlockedBy("has_essence", has(ModItems.KARMIC_ESSENCE.get())).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.KARMA_LAMP_3)
                .requires(Blocks.REDSTONE_LAMP, 1)
                .requires(ModItems.KARMIC_ESSENCE.get(), 3)
                .unlockedBy("has_essence", has(ModItems.KARMIC_ESSENCE.get())).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.KARMA_LAMP_4)
                .requires(Blocks.REDSTONE_LAMP, 1)
                .requires(ModItems.KARMIC_ESSENCE.get(), 4)
                .unlockedBy("has_essence", has(ModItems.KARMIC_ESSENCE.get())).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.KARMA_LAMP_5)
                .requires(Blocks.REDSTONE_LAMP, 1)
                .requires(ModItems.KARMIC_ESSENCE.get(), 5)
                .unlockedBy("has_essence", has(ModItems.KARMIC_ESSENCE.get())).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.KARMA_LAMP_6)
                .requires(Blocks.REDSTONE_LAMP, 1)
                .requires(ModItems.KARMIC_ESSENCE.get(), 6)
                .unlockedBy("has_essence", has(ModItems.KARMIC_ESSENCE.get())).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.KARMA_LAMP_7)
                .requires(Blocks.REDSTONE_LAMP, 1)
                .requires(ModItems.KARMIC_ESSENCE.get(), 7)
                .unlockedBy("has_essence", has(ModItems.KARMIC_ESSENCE.get())).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.KARMA_LAMP_8)
                .requires(Blocks.REDSTONE_LAMP, 1)
                .requires(ModItems.KARMIC_ESSENCE.get(), 8)
                .unlockedBy("has_essence", has(ModItems.KARMIC_ESSENCE.get())).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.KARMA_LAMP_10)
                .requires(ModBlocks.KARMA_LAMP_9)
                .requires(ModItems.KARMIC_ESSENCE.get())
                .unlockedBy("has_essence", has(ModItems.KARMIC_ESSENCE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.KARMA_LAMP_9)
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.REDSTONE_LAMP)
                .define('B', ModItems.KARMIC_ESSENCE.get())
                .unlockedBy("has_essence", has(ModItems.KARMIC_ESSENCE)).save(recipeOutput);

        oreSmelting(recipeOutput, KARMA_E_SMELTABLES, RecipeCategory.MISC, ModItems.KARMIC_ESSENCE.get(), 0.5F, 200, "essence");
    }
}
