package net.fot.fotslugcats.screen;

import net.fot.fotslugcats.FoTSlugcats;
import net.fot.fotslugcats.screen.custom.KarmaMenu;
import net.fot.fotslugcats.screen.custom.KarmaScreen;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

@EventBusSubscriber
public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(
            BuiltInRegistries.MENU, FoTSlugcats.MOD_ID);

    public static final Supplier<MenuType<KarmaMenu>> KRM_MENU = MENUS.register(
            "karma_menu",
            () -> new MenuType<>(
                    KarmaMenu::new,
                    FeatureFlags.DEFAULT_FLAGS));

    @SubscribeEvent // on the mod event bus only on the physical client
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(ModMenuTypes.KRM_MENU.get(), KarmaScreen::new);
    }
}
