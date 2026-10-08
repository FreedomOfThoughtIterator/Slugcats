package net.fot.fotslugcats.item;

import net.fot.fotslugcats.FoTSlugcats;
import net.fot.fotslugcats.block.ModBlocks;
import net.fot.fotslugcats.block.custom.BluefruitVineBlock;
import net.fot.fotslugcats.entity.ModEntities;
import net.fot.fotslugcats.item.custom.DataPearlItem;
import net.fot.fotslugcats.item.custom.KarmaFlowerItem;
import net.fot.fotslugcats.item.custom.KarmicEssenceItem;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.component.WritableBookContent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FoTSlugcats.MOD_ID);

    public static final DeferredItem<Item> BLUEFRUIT = ITEMS.register("bluefruit",
            () -> new ItemNameBlockItem(ModBlocks.BLUEFRUIT_VINE.get(), new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationModifier(2f).build()))
    );

    public static final DeferredItem<Item> PEBBLEFRUIT = ITEMS.register("pebblefruit",
            () -> new ItemNameBlockItem(ModBlocks.PEBBLEFRUIT_VINE.get(), new Item.Properties().food((new FoodProperties.Builder()).nutrition(8).saturationModifier(4f).build()))
    );
    public static final DeferredItem<Item> MOONFRUIT = ITEMS.register("moonfruit",
            () -> new ItemNameBlockItem(ModBlocks.MOONFRUIT_VINE.get(), new Item.Properties().food((new FoodProperties.Builder()).nutrition(8).saturationModifier(4f).build()))
    );
    public static final DeferredItem<Item> FREEDOMFRUIT = ITEMS.register("freedomfruit",
            () -> new ItemNameBlockItem(ModBlocks.FREEDOMFRUIT_VINE.get(), new Item.Properties().food((new FoodProperties.Builder()).nutrition(8).saturationModifier(4f).build()))
    );
    public static final DeferredItem<Item> SLUGMEAT = ITEMS.register("slugcat_meat",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(2).saturationModifier(0.3F).effect(new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).build()))
    );
    public static final DeferredItem<Item> COOKED_SLUGMEAT = ITEMS.register("cooked_slugcat_meat",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(6).saturationModifier(0.6F).build()))
    );


    public static final DeferredItem<Item> BANILLA = ITEMS.register("banilla",
            () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(12).saturationModifier(6f).build()))
    );

    public static final DeferredItem<Item> KARMA_FLOWER = ITEMS.register("karma_flower",
            () -> new KarmaFlowerItem(ModBlocks.KARMAFLOWER.get(), new Item.Properties().food((new FoodProperties.Builder()).nutrition(8).saturationModifier(4f).build()))
    );

    public static final DeferredItem<Item> KARMIC_ESSENCE = ITEMS.register("karmic_essence",
            () -> new KarmicEssenceItem(new Item.Properties().durability(8).fireResistant().rarity(Rarity.RARE))
    );
    public static final DeferredItem<Item> GOLDEN_DISC = ITEMS.register("golden_disc",
            () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.RARE))
    );

    public static final DeferredItem<Item> DATAPEARL = ITEMS.register("datapearl",
            () -> new DataPearlItem((new Item.Properties().rarity(Rarity.UNCOMMON).durability(500)))
    );

    public static final DeferredItem<Item> SLUGCAT_SPAWN_EGG = ITEMS.register("slugcat_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.SLUGCAT, 0xffeeff, 0xffeeff,
                    new Item.Properties())
    );
    public static final DeferredItem<Item> SURVIVOR_SPAWN_EGG = ITEMS.register("survivor_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.SURVIVOR, 0xffeeff, 0xffeeff,
                    new Item.Properties())
    );

    public static final DeferredItem<Item> MONK_SPAWN_EGG = ITEMS.register("monk_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.MONK, 0xffeeff, 0xffeeff,
                    new Item.Properties())
    );

    public static final DeferredItem<Item> HUNTER_SPAWN_EGG = ITEMS.register("hunter_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.HUNTER, 0xffeeff, 0xffeeff,
                    new Item.Properties())
    );

    //Return to when Slup model is finished
    public static final DeferredItem<Item> SLUP_SPAWN_EGG = ITEMS.register("slup_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.SLUP, 0xffeeff, 0xffeeff,
                    new Item.Properties())
    );


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
