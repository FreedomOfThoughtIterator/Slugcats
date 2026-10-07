package net.fot.fotslugcats.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fot.fotslugcats.FoTSlugcats;
import net.fot.fotslugcats.entity.custom.HunterSlugcatEntity;
import net.fot.fotslugcats.entity.custom.MonkSlugcatEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class HunterSlugcatRenderer extends MobRenderer<HunterSlugcatEntity, HunterModel<HunterSlugcatEntity>> {
    private final AdultAndBabyModelPair<HunterModel> models;
    public HunterSlugcatRenderer(EntityRendererProvider.Context context) {
        super(context, new HunterModel<>(context.bakeLayer(HunterModel.LAYER_LOCATION)), 0.25f);

        this.models = new AdultAndBabyModelPair(
                new HunterModel<>(context.bakeLayer(HunterModel.LAYER_LOCATION)),
                new SlugpupModel<>(context.bakeLayer(SlugpupModel.LAYER_LOCATION))
        );
    }

    @Override
    public ResourceLocation getTextureLocation(HunterSlugcatEntity hunterSlugcatEntity) {
        return ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID, "textures/entity/slugcat/hunter_slugcat.png");
    }

    @Override
    public void render(HunterSlugcatEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        //HOW THE five pebbles DO YOU WORK
        //this.model = this.models.getModel(entity.isBaby());

        if (entity.isBaby()) {
            poseStack.scale(0.3f, 0.3f, 0.3f);
        } else {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
