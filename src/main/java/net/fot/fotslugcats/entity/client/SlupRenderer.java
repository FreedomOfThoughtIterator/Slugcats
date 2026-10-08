package net.fot.fotslugcats.entity.client;

import net.fot.fotslugcats.FoTSlugcats;
import net.fot.fotslugcats.entity.custom.SlupEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SlupRenderer extends MobRenderer<SlupEntity, SlugpupModel<SlupEntity>> {
    public SlupRenderer(EntityRendererProvider.Context context) {
        super(context, new SlugpupModel<>(context.bakeLayer(SlugpupModel.LAYER_LOCATION)), 0.5f);
        this.model = new SlugpupModel<>(context.bakeLayer(SlugpupModel.LAYER_LOCATION));
    }

    @Override
    public ResourceLocation getTextureLocation(SlupEntity slupEntity) {
        return ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID, "textures/entity/slugcat/white_slugcat.png");
    }
}
