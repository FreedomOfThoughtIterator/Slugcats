package net.fot.fotslugcats.item;

import net.fot.fotslugcats.FoTSlugcats;
import net.fot.fotslugcats.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FoTSlugcats.MOD_ID);

    public static final Supplier<CreativeModeTab> FOTRW_TAB = CREATIVE_MODE_TAB.register("fot_rw_tab",
            () -> CreativeModeTab.builder()
                    .icon (() -> new ItemStack(ModItems.BLUEFRUIT.get()))
                    .title(Component.translatable("creativetab.fotslugcats.fot_rw"))
                    .displayItems(((itemDisplayParameters, output) -> {
                        output.accept(ModItems.SLUGCAT_SPAWN_EGG);
                        output.accept(ModItems.MONK_SPAWN_EGG);
                        output.accept(ModItems.SURVIVOR_SPAWN_EGG);
                        output.accept(ModItems.HUNTER_SPAWN_EGG);
                        output.accept(ModItems.VOID_SPAWN_EGG);
                        output.accept(ModItems.BLUEFRUIT);
                        output.accept(ModItems.BANILLA);
                        output.accept(ModItems.SLUGMEAT);
                        output.accept(ModItems.COOKED_SLUGMEAT);
                        output.accept(ModItems.KARMA_FLOWER);
                        output.accept(ModItems.KARMIC_ESSENCE);
                        output.accept(ModBlocks.WORMGRASS);
                        output.accept(ModBlocks.DOUBLE_WORMGRASS);
                        output.accept(ModBlocks.GENETICALLYMODIFIEDGRASS);
                        output.accept(ModBlocks.GENETICALLYMODIFIEDWEEDS);
                        output.accept(ModItems.DATAPEARL);
                        output.accept(ModBlocks.POLE);
                        output.accept(ModBlocks.POLECORNER);
                        output.accept(ModBlocks.POLECORNERJUNC);
                        output.accept(ModBlocks.POLEIJUNC);
                        output.accept(ModBlocks.POLETJUNC);
                        output.accept(ModBlocks.POLEPLUSJUNC);
                        output.accept(ModBlocks.DARK_ROCK);
                        output.accept(ModBlocks.DARK_BRICKS);
                        output.accept(ModBlocks.ITER_STEEL_CLEAN);
                        output.accept(ModBlocks.ITER_STEEL);
                        output.accept(ModBlocks.ITER_LATTICE);
                        output.accept(ModBlocks.ITER_COMP_BLUE);
                        output.accept(ModBlocks.ITER_COMP_RED);
                        output.accept(ModBlocks.ITER_TILE);
                        output.accept(ModBlocks.METAL_PLATE);
                        output.accept(ModBlocks.PANEL);
                        output.accept(ModBlocks.TRUSS);
                        output.accept(ModBlocks.VENTSMALL);
                        output.accept(ModBlocks.VENTCURVEDSMALL);
                        output.accept(ModBlocks.VENT_DUCT_BLOCK);
                        output.accept(ModBlocks.VENT_HUB_SMALL);
                        output.accept(ModBlocks.KARMA_LAMP_1);
                        output.accept(ModBlocks.KARMA_LAMP_2);
                        output.accept(ModBlocks.KARMA_LAMP_3);
                        output.accept(ModBlocks.KARMA_LAMP_4);
                        output.accept(ModBlocks.KARMA_LAMP_5);
                        output.accept(ModBlocks.KARMA_LAMP_6);
                        output.accept(ModBlocks.KARMA_LAMP_7);
                        output.accept(ModBlocks.KARMA_LAMP_8);
                        output.accept(ModBlocks.KARMA_LAMP_9);
                        output.accept(ModBlocks.KARMA_LAMP_10);
                        output.accept(ModBlocks.DATAPEARL_READER);
                    })).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
