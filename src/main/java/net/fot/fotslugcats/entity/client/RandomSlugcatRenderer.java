package net.fot.fotslugcats.entity.client;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.fot.fotslugcats.FoTSlugcats;
import net.fot.fotslugcats.entity.SlugcatVariant;
import net.fot.fotslugcats.entity.custom.RandomSlugcatEntity;
import net.fot.fotslugcats.entity.custom.SlugcatEntity;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class RandomSlugcatRenderer extends MobRenderer<RandomSlugcatEntity, SlugcatModel<RandomSlugcatEntity>> {
    private final AdultAndBabyModelPair<SlugcatModel> models;
    private static final Map<SlugcatVariant, ResourceLocation> LOCATION_BY_VARIANT = Util.make(Maps.newEnumMap(SlugcatVariant.class), map -> {
        map.put(SlugcatVariant.WHITE,
                ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID, "textures/entity/slugcat/slugcat_white.png"));
        map.put(SlugcatVariant.CYAN,
                ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID, "textures/entity/slugcat/slugcat_cyan.png"));
        map.put(SlugcatVariant.LIME,
                ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID, "textures/entity/slugcat/slugcat_lime.png"));
        map.put(SlugcatVariant.DARK_BLUE,
                ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID, "textures/entity/slugcat/slugcat_dark_blue.png"));
        map.put(SlugcatVariant.DARK_GREEN,
                ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID, "textures/entity/slugcat/slugcat_dark_green.png"));
        map.put(SlugcatVariant.DARK_YELLOW,
                ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID, "textures/entity/slugcat/slugcat_dark_yellow.png"));
    });

    //DO NOT TOUCH I don't know how I made this work but it does so DO NOT TOUCH OR CHANGE ANYTHING
    public RandomSlugcatRenderer(EntityRendererProvider.Context context) {
        super(context, new SlugcatModel<>(context.bakeLayer(SlugcatModel.LAYER_LOCATION)), 0.25f);
        this.models = new AdultAndBabyModelPair(
                new SlugcatModel<>(context.bakeLayer(SlugcatModel.LAYER_LOCATION)),
                new SlugpupModel<>(context.bakeLayer(SlugpupModel.LAYER_LOCATION))
        );
    }

    @Override
    public ResourceLocation getTextureLocation(RandomSlugcatEntity slugcatEntity) {
        return LOCATION_BY_VARIANT.get(slugcatEntity.getVariant());
    }

    @Override
    public void render(RandomSlugcatEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        //HOW THE five pebbles DO YOU WORK
        this.model = this.models.getModel(entity.isBaby());
        if (entity.isBaby()) {
            poseStack.scale(0.3f, 0.3f, 0.3f);
        } else {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
