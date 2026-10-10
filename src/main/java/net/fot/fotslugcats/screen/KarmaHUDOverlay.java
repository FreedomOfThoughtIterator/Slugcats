package net.fot.fotslugcats.screen;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fot.fotslugcats.FoTSlugcats;
import net.fot.fotslugcats.attributes.ModAttributes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderGuiEvent;

@EventBusSubscriber(Dist.CLIENT)
public class KarmaHUDOverlay {
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

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void eventHandler(RenderGuiEvent.Pre event) {
        Player entity = Minecraft.getInstance().player;
        int imgh = 60;
        int imgw = 60;
        int w = event.getGuiGraphics().guiWidth() - (imgw / 2);
        int h = event.getGuiGraphics().guiHeight() - (imgh / 2);
        double Karma = entity.getAttribute(ModAttributes.KARMA).getValue();
        double Max = entity.getAttribute(ModAttributes.MAX_KARMA).getValue();

        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.enableBlend();
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        RenderSystem.setShaderColor(1, 1, 1, 1);

        if (entity.getAttribute(ModAttributes.PROTECT_KARMA).getValue() == 1) {
            event.getGuiGraphics().blit(KRM_PROTECT, 21, h - 39, 0, 0, imgw, imgh, imgw, imgh);
        }
        event.getGuiGraphics().blit(KRM_BCK, 21, h - 39, 0, 0, imgw, imgh, imgw, imgh);

        if (Karma == 1) {
            event.getGuiGraphics().blit(KRM_1, 21, h - 39, 0, 0, imgw, imgh, imgw, imgh);
        } else if (Karma == 2){
            event.getGuiGraphics().blit(KRM_2, 21, h - 39, 0, 0, imgw, imgh, imgw, imgh);
        } else if (Karma == 3) {
            event.getGuiGraphics().blit(KRM_3, 21, h - 39, 0, 0, imgw, imgh, imgw, imgh);
        } else if (Karma == 4) {
            event.getGuiGraphics().blit(KRM_4, 21, h - 39, 0, 0, imgw, imgh, imgw, imgh);
        } else if (Karma == 5) {
            event.getGuiGraphics().blit(KRM_5, 21, h - 39, 0, 0, imgw, imgh, imgw, imgh);
        }

        else if (Karma == 6 && Max == 7) {
            event.getGuiGraphics().blit(KRM_6_7MAX, 21, h - 39, 0, 0, imgw, imgh, imgw, imgh);
        } else if (Karma == 6 && Max == 8) {
            event.getGuiGraphics().blit(KRM_6_8MAX, 21, h - 39, 0, 0, imgw, imgh, imgw, imgh);
        } else if (Karma == 6 && Max == 9) {
            event.getGuiGraphics().blit(KRM_6_9MAX, 21, h - 39, 0, 0, imgw, imgh, imgw, imgh);
        } else if (Karma == 6 && Max == 10) {
            event.getGuiGraphics().blit(KRM_6_10MAX, 21, h - 39, 0, 0, imgw, imgh, imgw, imgh);
        }

        else if (Karma == 7 && Max == 7) {
            event.getGuiGraphics().blit(KRM_7_7MAX, 21, h - 39, 0, 0, imgw, imgh, imgw, imgh);
        } else if (Karma == 7 && Max == 8) {
            event.getGuiGraphics().blit(KRM_7_8MAX, 21, h - 39, 0, 0, imgw, imgh, imgw, imgh);
        } else if (Karma == 7 && Max == 9) {
            event.getGuiGraphics().blit(KRM_7_9MAX, 21, h - 39, 0, 0, imgw, imgh, imgw, imgh);
        } else if (Karma == 7 && Max == 10) {
            event.getGuiGraphics().blit(KRM_7_10MAX, 21, h - 39, 0, 0, imgw, imgh, imgw, imgh);
        }

        else if (Karma == 8 && Max == 8) {
            event.getGuiGraphics().blit(KRM_8_8MAX, 21, h - 39, 0, 0, imgw, imgh, imgw, imgh);
        } else if (Karma == 8 && Max == 9) {
            event.getGuiGraphics().blit(KRM_8_9MAX, 21, h - 39, 0, 0, imgw, imgh, imgw, imgh);
        } else if (Karma == 8 && Max == 10) {
            event.getGuiGraphics().blit(KRM_8_10MAX, 21, h - 39, 0, 0, imgw, imgh, imgw, imgh);
        }

        else if (Karma == 9 && Max == 9) {
            event.getGuiGraphics().blit(KRM_9_9MAX, 21, h - 39, 0, 0, imgw, imgh, imgw, imgh);
        } else if (Karma == 9 && Max == 10) {
            event.getGuiGraphics().blit(KRM_9_10MAX, 21, h - 39, 0, 0, imgw, imgh, imgw, imgh);
        } else if (Karma == 10 && Max == 10) {
            event.getGuiGraphics().blit(KRM_10_10MAX, 21, h - 39, 0, 0, imgw, imgh, imgw, imgh);
        }

        RenderSystem.depthMask(true);
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();
        RenderSystem.disableBlend();
        RenderSystem.setShaderColor(1, 1, 1, 1);
    }
}
