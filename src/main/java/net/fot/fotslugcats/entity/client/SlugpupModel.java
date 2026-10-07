package net.fot.fotslugcats.entity.client;// Made with Blockbench 5.2.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.fot.fotslugcats.FoTSlugcats;
import net.fot.fotslugcats.entity.client.SlugcatAnimations;
import net.fot.fotslugcats.entity.client.SlugpupAnimations;
import net.fot.fotslugcats.entity.custom.SlugcatEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class SlugpupModel<T extends SlugcatEntity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID, "slugpup"), "main");
	private final ModelPart bdoywhole;
	private final ModelPart head;
	private final ModelPart leftear;
	private final ModelPart rightear;
	private final ModelPart neck;
	private final ModelPart chest;
	private final ModelPart top;
	private final ModelPart bottom;
	private final ModelPart rightleg;
	private final ModelPart topleg;
	private final ModelPart middle;
	private final ModelPart bottomleg;
	private final ModelPart foot;
	private final ModelPart leftleg;
	private final ModelPart topleg2;
	private final ModelPart middle2;
	private final ModelPart bottomleg2;
	private final ModelPart foot2;
	private final ModelPart tail;
	private final ModelPart tail1;
	private final ModelPart tail2;
	private final ModelPart tail3;

	public SlugpupModel(ModelPart root) {
		this.bdoywhole = root.getChild("bdoywhole");
		this.head = this.bdoywhole.getChild("head");
		this.leftear = this.head.getChild("leftear");
		this.rightear = this.head.getChild("rightear");
		this.neck = this.bdoywhole.getChild("neck");
		this.chest = this.bdoywhole.getChild("chest");
		this.top = this.chest.getChild("top");
		this.bottom = this.chest.getChild("bottom");
		this.rightleg = this.bottom.getChild("rightleg");
		this.topleg = this.rightleg.getChild("topleg");
		this.middle = this.topleg.getChild("middle");
		this.bottomleg = this.middle.getChild("bottomleg");
		this.foot = this.bottomleg.getChild("foot");
		this.leftleg = this.bottom.getChild("leftleg");
		this.topleg2 = this.leftleg.getChild("topleg2");
		this.middle2 = this.topleg2.getChild("middle2");
		this.bottomleg2 = this.middle2.getChild("bottomleg2");
		this.foot2 = this.bottomleg2.getChild("foot2");
		this.tail = this.bottom.getChild("tail");
		this.tail1 = this.tail.getChild("tail1");
		this.tail2 = this.tail1.getChild("tail2");
		this.tail3 = this.tail2.getChild("tail3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bdoywhole = partdefinition.addOrReplaceChild("bdoywhole", CubeListBuilder.create(), PartPose.offset(0.0F, 4.5362F, 0.8768F));

		PartDefinition head = bdoywhole.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 23).addBox(-5.0F, -9.9914F, -6.3695F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(94, 50).addBox(-2.0F, -0.9914F, -8.1695F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.8362F, 0.6232F));

		PartDefinition chest_r1 = head.addOrReplaceChild("chest_r1", CubeListBuilder.create().texOffs(94, 46).addBox(-1.0F, -0.5F, -1.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.15F, -1.9914F, -7.1695F, -0.5149F, 0.0F, 1.5708F));

		PartDefinition chest_r2 = head.addOrReplaceChild("chest_r2", CubeListBuilder.create().texOffs(94, 42).addBox(-2.0F, -0.5F, -1.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.15F, -1.9914F, -7.1695F, -0.5149F, 0.0F, -1.5708F));

		PartDefinition chest_r3 = head.addOrReplaceChild("chest_r3", CubeListBuilder.create().texOffs(68, 20).addBox(-2.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.7709F, -7.3787F, 0.2705F, 0.0F, 0.0F));

		PartDefinition chest_r4 = head.addOrReplaceChild("chest_r4", CubeListBuilder.create().texOffs(68, 15).addBox(-2.0F, -1.5F, -1.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5914F, -7.3695F, 0.0873F, 0.0F, 0.0F));

		PartDefinition leftear = head.addOrReplaceChild("leftear", CubeListBuilder.create().texOffs(80, 14).addBox(-2.0F, -11.5462F, -2.3434F, 4.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -8.6538F, 1.3434F, -0.9319F, 0.169F, 0.1243F));

		PartDefinition cube_r1 = leftear.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(66, 76).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.4462F, 1.1566F, 0.2443F, 0.0F, 0.0F));

		PartDefinition rightear = head.addOrReplaceChild("rightear", CubeListBuilder.create().texOffs(34, 80).addBox(-2.0F, -11.5462F, -2.3434F, 4.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -8.6538F, 1.3434F, -0.9319F, -0.169F, -0.1243F));

		PartDefinition cube_r2 = rightear.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 79).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.4462F, 1.1566F, 0.2443F, 0.0F, 0.0F));

		PartDefinition neck = bdoywhole.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(75, 44).addBox(-2.0F, 1.5F, -2.75F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -14.8362F, 1.1232F));

		PartDefinition chest = bdoywhole.addOrReplaceChild("chest", CubeListBuilder.create(), PartPose.offset(0.0F, 0.6724F, -0.7463F));

		PartDefinition top = chest.addOrReplaceChild("top", CubeListBuilder.create(), PartPose.offset(0.0F, -9.0F, 0.5F));

		PartDefinition chest_r5 = top.addOrReplaceChild("chest_r5", CubeListBuilder.create().texOffs(42, 24).addBox(-3.0F, -4.0F, -4.0F, 9.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 3.3F, -1.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition bottom = chest.addOrReplaceChild("bottom", CubeListBuilder.create(), PartPose.offset(-0.5F, -2.0F, 1.0F));

		PartDefinition chest_r6 = bottom.addOrReplaceChild("chest_r6", CubeListBuilder.create().texOffs(40, 44).addBox(-3.0F, -4.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 2.0F, -0.05F, 0.1309F, 0.0F, 0.0F));

		PartDefinition rightleg = bottom.addOrReplaceChild("rightleg", CubeListBuilder.create(), PartPose.offsetAndRotation(0.8F, -2.0F, 0.0F, 0.0F, -0.1047F, 0.0F));

		PartDefinition topleg = rightleg.addOrReplaceChild("topleg", CubeListBuilder.create().texOffs(0, 62).addBox(-1.6815F, -0.41F, -4.2178F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.1612F, 5.7477F, 0.3758F, -0.094F, 0.2566F, 0.0413F));

		PartDefinition cube_r3 = topleg.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(48, 63).addBox(-3.0F, -3.0F, -4.5F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9185F, 0.0034F, 0.3046F, 0.0F, 0.0F, 0.7156F));

		PartDefinition cube_r4 = topleg.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(76, 0).addBox(-3.0F, -8.0F, -1.5F, 6.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3185F, 7.1034F, 1.2046F, -0.2007F, -0.0007F, -0.0001F));

		PartDefinition middle = topleg.addOrReplaceChild("middle", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 8.5F, -2.9F, 0.0523F, 0.0027F, -0.0523F));

		PartDefinition cube_r5 = middle.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(80, 88).addBox(-2.0F, -2.0F, -4.0F, 5.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8185F, -2.4161F, 2.7917F, 1.0123F, 0.0F, 0.0F));

		PartDefinition cube_r6 = middle.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(48, 90).addBox(-2.0F, -2.0F, -5.0F, 5.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8185F, -4.3161F, 4.3917F, 0.8901F, 0.0F, 0.0F));

		PartDefinition bottomleg = middle.addOrReplaceChild("bottomleg", CubeListBuilder.create(), PartPose.offsetAndRotation(1.3685F, 2.1845F, 5.0878F, 0.061F, 0.0021F, -0.0348F));

		PartDefinition cube_r7 = bottomleg.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(64, 92).addBox(-1.0F, -1.6126F, -0.0974F, 5.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 0.8994F, 0.9039F, -0.4189F, 0.0F, 0.0F));

		PartDefinition cube_r8 = bottomleg.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(80, 30).addBox(-1.0F, -1.6126F, -2.0974F, 5.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 0.8994F, 0.1039F, -0.2443F, 0.0F, 0.0F));

		PartDefinition foot = bottomleg.addOrReplaceChild("foot", CubeListBuilder.create().texOffs(46, 15).addBox(-2.5F, -0.5F, -4.6F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.9F, -0.9F));

		PartDefinition cube_r9 = foot.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(94, 11).addBox(-2.0F, -2.0F, -5.0F, 5.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -0.3F, 0.4F, 0.3316F, 0.0F, 0.0F));

		PartDefinition leftleg = bottom.addOrReplaceChild("leftleg", CubeListBuilder.create(), PartPose.offsetAndRotation(0.2F, -2.0F, 0.0F, 0.0F, 0.1047F, 0.0F));

		PartDefinition topleg2 = leftleg.addOrReplaceChild("topleg2", CubeListBuilder.create().texOffs(24, 63).addBox(-4.3185F, -0.41F, -4.2178F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1612F, 5.7477F, 0.3758F, -0.094F, -0.2566F, -0.0413F));

		PartDefinition cube_r10 = topleg2.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(70, 63).addBox(0.0F, -3.0F, -4.5F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9185F, 0.0034F, 0.3046F, 0.0F, 0.0F, -0.7156F));

		PartDefinition cube_r11 = topleg2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(48, 76).addBox(-3.0F, -8.0F, -1.5F, 6.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3185F, 7.1034F, 1.2046F, -0.2007F, 0.0007F, 0.0001F));

		PartDefinition middle2 = topleg2.addOrReplaceChild("middle2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 8.5F, -2.9F, 0.0523F, -0.0027F, 0.0523F));

		PartDefinition cube_r12 = middle2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(14, 90).addBox(-3.0F, -2.0F, -4.0F, 5.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8185F, -2.4161F, 2.7917F, 1.0123F, 0.0F, 0.0F));

		PartDefinition cube_r13 = middle2.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(92, 63).addBox(-3.0F, -2.0F, -5.0F, 5.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8185F, -4.3161F, 4.3917F, 0.8901F, 0.0F, 0.0F));

		PartDefinition bottomleg2 = middle2.addOrReplaceChild("bottomleg2", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.3685F, 2.1845F, 5.0878F, 0.061F, -0.0021F, 0.0348F));

		PartDefinition cube_r14 = bottomleg2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(94, 0).addBox(-4.0F, -1.6126F, -0.0974F, 5.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.8994F, 0.9039F, -0.4189F, 0.0F, 0.0F));

		PartDefinition cube_r15 = bottomleg2.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(80, 76).addBox(-4.0F, -1.6126F, -2.0974F, 5.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.8994F, 0.1039F, -0.2443F, 0.0F, 0.0F));

		PartDefinition foot2 = bottomleg2.addOrReplaceChild("foot2", CubeListBuilder.create().texOffs(74, 55).addBox(-2.5F, -0.2F, -4.9F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.6F, -0.5F));

		PartDefinition cube_r16 = foot2.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(94, 17).addBox(-3.0F, -2.0F, -5.0F, 5.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.1F, 0.3316F, 0.0F, 0.0F));

		PartDefinition tail = bottom.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(1.4926F, 1.8323F, 1.1636F));

		PartDefinition cube_r17 = tail.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(2, 2).addBox(-4.0F, -4.0F, -3.0F, 9.0F, 9.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 1.75F, 1.0F, -0.6545F, 0.0F, 0.0F));

		PartDefinition tail1 = tail.addOrReplaceChild("tail1", CubeListBuilder.create(), PartPose.offset(-1.0F, 5.75F, 9.0F));

		PartDefinition cube_r18 = tail1.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(2, 45).addBox(-4.0F, -2.8369F, -3.0027F, 7.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 2.2163F, 0.0647F, -0.829F, 0.0F, 0.0F));

		PartDefinition tail2 = tail1.addOrReplaceChild("tail2", CubeListBuilder.create(), PartPose.offset(0.3074F, 6.5454F, 5.2827F));

		PartDefinition cube_r19 = tail2.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(50, 3).addBox(-2.0F, -1.8107F, -0.7755F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8074F, 0.3209F, -1.0179F, -0.6981F, 0.0F, 0.0F));

		PartDefinition tail3 = tail2.addOrReplaceChild("tail3", CubeListBuilder.create(), PartPose.offset(-0.3F, 5.6F, 5.1F));

		PartDefinition cube_r20 = tail3.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(15, 80).addBox(0.0F, 1.1631F, 0.9973F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4074F, -4.7291F, -4.2179F, -0.3491F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(SlugcatEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch);

		this.animateWalk(SlugpupAnimations.walking, limbSwing, limbSwingAmount, 2f, 1f);
		this.animate(entity.idleAnimationState, SlugpupAnimations.idle, ageInTicks, 1f);
	}

	private void applyHeadRotation(float headYaw, float headPitch) {
		headYaw = Mth.clamp(headYaw, -30f, 30f);
		headPitch = Mth.clamp(headPitch, -25f, 45f);

		this.head.yRot = headYaw * ((float)Mth.PI / 180f);
		this.head.xRot = headPitch * ((float)Mth.PI / 180f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		bdoywhole.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}

	@Override
	public ModelPart root() {
		return bdoywhole;
	}
}