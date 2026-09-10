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
                        output.accept(ModItems.BLUEFRUIT);
                        output.accept(ModItems.BANILLA);
                        output.accept(ModItems.KARMA_FLOWER);
                        output.accept(ModItems.KARMIC_ESSENCE);
                        output.accept(ModBlocks.WORMGRASS);
                        output.accept(ModBlocks.DOUBLE_WORMGRASS);
                        output.accept(ModBlocks.GENETICALLYMODIFIEDGRASS);
                        output.accept(ModBlocks.GENETICALLYMODIFIEDWEEDS);
                    })).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
