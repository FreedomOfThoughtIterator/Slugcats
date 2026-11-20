package net.fot.fotslugcats.util;

import net.fot.fotslugcats.FoTSlugcats;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;


public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> EXAMPLE = createTag("example");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID, name));
        }
    }
    public static class Items {
        public static final TagKey<Item> SLUG_FOOD = createTag("slug_food");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID, name));
        }
    }
}
