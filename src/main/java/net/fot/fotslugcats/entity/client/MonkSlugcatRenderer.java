package net.fot.fotslugcats.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fot.fotslugcats.FoTSlugcats;
import net.fot.fotslugcats.entity.custom.MonkSlugcatEntity;
import net.fot.fotslugcats.entity.custom.SurvivorSlugcatEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MonkSlugcatRenderer extends MobRenderer<MonkSlugcatEntity, SlugcatModel<MonkSlugcatEntity>> {
    private final AdultAndBabyModelPair<SlugcatModel> models;
    public MonkSlugcatRenderer(EntityRendererProvider.Context context) {
        super(context, new SlugcatModel<>(context.bakeLayer(SlugcatModel.LAYER_LOCATION)), 0.25f);
        this.models = new AdultAndBabyModelPair(
                new SlugcatModel<>(context.bakeLayer(SlugcatModel.LAYER_LOCATION)),
                new SlugpupModel<>(context.bakeLayer(SlugpupModel.LAYER_LOCATION))
        );
    }

    @Override
    public ResourceLocation getTextureLocation(MonkSlugcatEntity monkSlugcatEntity) {
        return ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID, "textures/entity/slugcat/monk_slugcat.png");
    }

    @Override
    public void render(MonkSlugcatEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
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
