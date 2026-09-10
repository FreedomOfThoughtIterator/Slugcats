package net.fot.fotslugcats.item;

import net.fot.fotslugcats.FoTSlugcats;
import net.fot.fotslugcats.block.ModBlocks;
import net.fot.fotslugcats.block.custom.BluefruitVineBlock;
import net.fot.fotslugcats.item.custom.KarmaFlowerItem;
import net.fot.fotslugcats.item.custom.KarmicEssenceItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FoTSlugcats.MOD_ID);

    public static final DeferredItem<Item> BLUEFRUIT = ITEMS.register("bluefruit",
            () -> new ItemNameBlockItem(ModBlocks.BLUEFRUIT_VINE.get(), new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationModifier(0.5f).build()))
    );

    public static final DeferredItem<Item> BANILLA = ITEMS.register("banilla",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(12).saturationModifier(0.75f).build()))
    );

    public static final DeferredItem<Item> KARMA_FLOWER = ITEMS.register("karma_flower",
            () -> new KarmaFlowerItem(ModBlocks.KARMAFLOWER.get(), new Item.Properties().food((new FoodProperties.Builder()).nutrition(8).saturationModifier(0.7f).build()))
    );

    public static final DeferredItem<Item> KARMIC_ESSENCE = ITEMS.register("karmic_essence",
            () -> new KarmicEssenceItem(new Item.Properties().durability(8).fireResistant().rarity(Rarity.RARE))
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
