package net.fot.fotslugcats.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fot.fotslugcats.FoTSlugcats;
import net.fot.fotslugcats.entity.custom.SlugcatEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SlugcatRenderer extends MobRenderer<SlugcatEntity, SlugcatModel<SlugcatEntity>> {
    private final AdultAndBabyModelPair<SlugcatModel> models;
    //DO NOT TOUCH I don't know how I made this work but it does so DO NOT TOUCH OR CHANGE ANYTHING
    public SlugcatRenderer(EntityRendererProvider.Context context) {
        super(context, new SlugcatModel<>(context.bakeLayer(SlugcatModel.LAYER_LOCATION)), 0.25f);
        this.models = new AdultAndBabyModelPair(
                new SlugcatModel<>(context.bakeLayer(SlugcatModel.LAYER_LOCATION)),
                new SlugpupModel<>(context.bakeLayer(SlugpupModel.LAYER_LOCATION))
        );
    }

    @Override
    public ResourceLocation getTextureLocation(SlugcatEntity slugcatEntity) {
        return ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID, "textures/entity/slugcat/slugcat_white.png");
    }

    @Override
    public void render(SlugcatEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        this.model = this.models.getModel(entity.isBaby());
        poseStack.scale(0.4f, 0.4f, 0.4f);

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
