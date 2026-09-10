package net.fot.fotslugcats.screen.custom;

import net.fot.fotslugcats.FoTSlugcats;
import net.fot.fotslugcats.screen.ModMenuTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class KarmaMenu extends AbstractContainerMenu {

    protected KarmaMenu(@Nullable MenuType<?> menuType, int containerId) {
        super(menuType, containerId);
    }

    public KarmaMenu(int containerId, Inventory playerInv) {
        super(ModMenuTypes.KRM_MENU.get(), containerId);
    }

    //public KarmaMenu(int containerId, Inventory playerInventory) {
    //}

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return null;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }
}
