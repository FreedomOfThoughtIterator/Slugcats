package net.fot.fotslugcats.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fot.fotslugcats.FoTSlugcats;
import net.fot.fotslugcats.entity.custom.HunterSlugcatEntity;
import net.fot.fotslugcats.entity.custom.VoidSlugcatEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class VoidSlugcatRenderer extends MobRenderer<VoidSlugcatEntity, VoidModel<VoidSlugcatEntity>> {

    public VoidSlugcatRenderer(EntityRendererProvider.Context context) {
        super(context, new VoidModel<>(context.bakeLayer(VoidModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(VoidSlugcatEntity hunterSlugcatEntity) {
        return ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID, "textures/entity/slugcat/void_slugcat.png");
    }

    @Override
    public void render(VoidSlugcatEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.scale(0.4f, 0.4f, 0.4f);
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
