package net.fot.fotslugcats.screen.custom;

import net.fot.fotslugcats.FoTSlugcats;
import net.fot.fotslugcats.attributes.ModAttributes;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class KarmaScreen extends AbstractContainerScreen<KarmaMenu> {
    public static final ResourceLocation KRMS_BCK = ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID,
            "textures/gui/karma/karmabck.png"
    );
    public static final ResourceLocation KRM_PROTECT = ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID,
            "textures/karma/karmaprotection.png"
    );
    public static final ResourceLocation KRM_BCK = ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID,
            "textures/karma/karmabackground.png"
    );
    public static final ResourceLocation KRM_1 = ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID,
            "textures/karma/karma1.png"
    );
    public static final ResourceLocation KRM_2 = ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID,
            "textures/karma/karma2.png"
    );
    public static final ResourceLocation KRM_3 = ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID,
            "textures/karma/karma3.png"
    );
    public static final ResourceLocation KRM_4 = ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID,
            "textures/karma/karma4.png"
    );
    public static final ResourceLocation KRM_5 = ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID,
            "textures/karma/karma5.png"
    );

    public static final ResourceLocation KRM_6_7MAX = ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID,
            "textures/karma/karma6_7max.png"
    );
    public static final ResourceLocation KRM_7_7MAX = ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID,
            "textures/karma/karma7_7max.png"
    );

    public static final ResourceLocation KRM_6_8MAX = ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID,
            "textures/karma/karma6_8max.png"
    );
    public static final ResourceLocation KRM_7_8MAX = ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID,
            "textures/karma/karma7_8max.png"
    );
    public static final ResourceLocation KRM_8_8MAX = ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID,
            "textures/karma/karma8_8max.png"
    );

    public static final ResourceLocation KRM_6_9MAX = ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID,
            "textures/karma/karma6_9max.png"
    );
    public static final ResourceLocation KRM_7_9MAX = ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID,
            "textures/karma/karma7_9max.png"
    );
    public static final ResourceLocation KRM_8_9MAX = ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID,
            "textures/karma/karma8_9max.png"
    );
    public static final ResourceLocation KRM_9_9MAX = ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID,
            "textures/karma/karma9_9max.png"
    );

    public static final ResourceLocation KRM_6_10MAX = ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID,
            "textures/karma/karma6_10max.png"
    );
    public static final ResourceLocation KRM_7_10MAX = ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID,
            "textures/karma/karma7_10max.png"
    );
    public static final ResourceLocation KRM_8_10MAX = ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID,
            "textures/karma/karma8_10max.png"
    );
    public static final ResourceLocation KRM_9_10MAX = ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID,
            "textures/karma/karma9_10max.png"
    );
    public static final ResourceLocation KRM_10_10MAX = ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID,
            "textures/karma/karma10_10max.png"
    );
    public static final ResourceLocation KRM_MASK = ResourceLocation.fromNamespaceAndPath(
            FoTSlugcats.MOD_ID, "karma/karmamask"
    );
    public static final ResourceLocation KRM_TEST = ResourceLocation.fromNamespaceAndPath(
            FoTSlugcats.MOD_ID, "textures/gui/sprites/karma/karmamask.png"
    );

    public double Karma = 1;
    public double Max = 5;
    public Inventory inv;

    public KarmaScreen(KarmaMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);

        this.Karma = playerInventory.player.getAttribute(ModAttributes.KARMA).getValue();
        this.Max = playerInventory.player.getAttribute(ModAttributes.MAX_KARMA).getValue();
        this.inv = playerInventory;
        this.imageHeight = 10000;
        this.imageWidth = 10000;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1) {
        int imgh = 80;
        int imgw = 80;
        int w = guiGraphics.guiWidth();
        int h = guiGraphics.guiHeight();
        guiGraphics.blit(KRMS_BCK, 0, 0, 0, 0, 10000, 10000, 1000, 1000);
        guiGraphics.blit(KRM_BCK, (w/2) - (imgw / 2), h-((h/2) + (imgw / 2)), 0, 0, imgw, imgh, imgw, imgh);
        renderKarmaSymbol(guiGraphics, w, h);
        //karmaChangeMask(guiGraphics, w, h);
    }

    protected void renderKarmaSymbol(GuiGraphics guiGraphics, int w, int h) {
        int imgw = 80;
        int imgh = 80;
        if (Karma == 1) {
            guiGraphics.blit(KRM_1, (w/2) - (imgw / 2), h-((h/2) + (imgw / 2)), 0, 0, imgw, imgh, imgw, imgh);
        } else if (Karma == 2){
            guiGraphics.blit(KRM_2, (w/2) - (imgw / 2), h-((h/2) + (imgw / 2)), 0, 0, imgw, imgh, imgw, imgh);
        } else if (Karma == 3) {
            guiGraphics.blit(KRM_3, (w/2) - (imgw / 2), h-((h/2) + (imgw / 2)), 0, 0, imgw, imgh, imgw, imgh);
        } else if (Karma == 4) {
            guiGraphics.blit(KRM_4, (w/2) - (imgw / 2), h-((h/2) + (imgw / 2)), 0, 0, imgw, imgh, imgw, imgh);
        } else if (Karma == 5) {
            guiGraphics.blit(KRM_5, (w/2) - (imgw / 2), h-((h/2) + (imgw / 2)), 0, 0, imgw, imgh, imgw, imgh);
        }

        else if (Karma == 6 && Max == 7) {
            guiGraphics.blit(KRM_6_7MAX, (w/2) - (imgw / 2), h-((h/2) + (imgw / 2)), 0, 0, imgw, imgh, imgw, imgh);
        } else if (Karma == 6 && Max == 8) {
            guiGraphics.blit(KRM_6_8MAX, (w/2) - (imgw / 2), h-((h/2) + (imgw / 2)), 0, 0, imgw, imgh, imgw, imgh);
        } else if (Karma == 6 && Max == 9) {
            guiGraphics.blit(KRM_6_9MAX, (w/2) - (imgw / 2), h-((h/2) + (imgw / 2)), 0, 0, imgw, imgh, imgw, imgh);
        } else if (Karma == 6 && Max == 10) {
            guiGraphics.blit(KRM_6_10MAX, (w/2) - (imgw / 2), h-((h/2) + (imgw / 2)), 0, 0, imgw, imgh, imgw, imgh);
        }

        else if (Karma == 7 && Max == 7) {
            guiGraphics.blit(KRM_7_7MAX, (w/2) - (imgw / 2), h-((h/2) + (imgw / 2)), 0, 0, imgw, imgh, imgw, imgh);
        } else if (Karma == 7 && Max == 8) {
            guiGraphics.blit(KRM_7_8MAX, (w/2) - (imgw / 2), h-((h/2) + (imgw / 2)), 0, 0, imgw, imgh, imgw, imgh);
        } else if (Karma == 7 && Max == 9) {
            guiGraphics.blit(KRM_7_9MAX, (w/2) - (imgw / 2), h-((h/2) + (imgw / 2)), 0, 0, imgw, imgh, imgw, imgh);
        } else if (Karma == 7 && Max == 10) {
            guiGraphics.blit(KRM_7_10MAX, (w/2) - (imgw / 2), h-((h/2) + (imgw / 2)), 0, 0, imgw, imgh, imgw, imgh);
        }

        else if (Karma == 8 && Max == 8) {
            guiGraphics.blit(KRM_8_8MAX, (w/2) - (imgw / 2), h-((h/2) + (imgw / 2)), 0, 0, imgw, imgh, imgw, imgh);
        } else if (Karma == 8 && Max == 9) {
            guiGraphics.blit(KRM_8_9MAX, (w/2) - (imgw / 2), h-((h/2) + (imgw / 2)), 0, 0, imgw, imgh, imgw, imgh);
        } else if (Karma == 8 && Max == 10) {
            guiGraphics.blit(KRM_8_10MAX, (w/2) - (imgw / 2), h-((h/2) + (imgw / 2)), 0, 0, imgw, imgh, imgw, imgh);
        }

        else if (Karma == 9 && Max == 9) {
            guiGraphics.blit(KRM_9_9MAX, (w/2) - (imgw / 2), h-((h/2) + (imgw / 2)), 0, 0, imgw, imgh, imgw, imgh);
        } else if (Karma == 9 && Max == 10) {
            guiGraphics.blit(KRM_9_10MAX, (w/2) - (imgw / 2), h-((h/2) + (imgw / 2)), 0, 0, imgw, imgh, imgw, imgh);
        } else if (Karma == 10 && Max == 10) {
            guiGraphics.blit(KRM_10_10MAX, (w/2) - (imgw / 2), h-((h/2) + (imgw / 2)), 0, 0, imgw, imgh, imgw, imgh);
        }
    }

    private void karmaChangeMask(GuiGraphics guiGraphics, int w, int h) {
        guiGraphics.blit(KRM_TEST, (w/2) - (80 / 2), h-((h/2) + (80 / 2)), 0, 80, 80, 80, 80, 720);
        //guiGraphics.blitSprite(KRM_MASK, (w/2) - (80 / 2), h-((h/2) + (80 / 2)), 80, 80);
    }

    @Override
    protected void containerTick() {
        super.containerTick();

        this.Karma = inv.player.getAttribute(ModAttributes.KARMA).getValue();
        this.Max = inv.player.getAttribute(ModAttributes.MAX_KARMA).getValue();
    }
}
