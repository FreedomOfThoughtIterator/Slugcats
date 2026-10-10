package net.fot.fotslugcats.entity.client;// Made with Blockbench 5.2.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import net.fot.fotslugcats.entity.client.VoidAnimations;
import net.fot.fotslugcats.entity.custom.VoidSlugcatEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.fot.fotslugcats.FoTSlugcats;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class VoidModel<T extends VoidSlugcatEntity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID, "void"), "main");
	private final ModelPart bdoywhole;
	private final ModelPart head;
	private final ModelPart leftear;
	private final ModelPart rightear;
	private final ModelPart neck;
	private final ModelPart chest;
	private final ModelPart top;
	private final ModelPart arms;
	private final ModelPart leftarm;
	private final ModelPart toparm2;
	private final ModelPart bottomarm2;
	private final ModelPart hand2;
	private final ModelPart rightarm;
	private final ModelPart toparm3;
	private final ModelPart bottomarm3;
	private final ModelPart hand3;
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
	private final ModelPart tail4;

	public VoidModel(ModelPart root) {
		this.bdoywhole = root.getChild("bdoywhole");
		this.head = this.bdoywhole.getChild("head");
		this.leftear = this.head.getChild("leftear");
		this.rightear = this.head.getChild("rightear");
		this.neck = this.bdoywhole.getChild("neck");
		this.chest = this.bdoywhole.getChild("chest");
		this.top = this.chest.getChild("top");
		this.arms = this.top.getChild("arms");
		this.leftarm = this.arms.getChild("leftarm");
		this.toparm2 = this.leftarm.getChild("toparm2");
		this.bottomarm2 = this.toparm2.getChild("bottomarm2");
		this.hand2 = this.bottomarm2.getChild("hand2");
		this.rightarm = this.arms.getChild("rightarm");
		this.toparm3 = this.rightarm.getChild("toparm3");
		this.bottomarm3 = this.toparm3.getChild("bottomarm3");
		this.hand3 = this.bottomarm3.getChild("hand3");
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
		this.tail4 = this.tail3.getChild("tail4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bdoywhole = partdefinition.addOrReplaceChild("bdoywhole", CubeListBuilder.create(), PartPose.offset(0.0F, 0.5362F, 0.8768F));

		PartDefinition head = bdoywhole.addOrReplaceChild("head", CubeListBuilder.create().texOffs(41, 24).addBox(-5.0F, -9.9914F, -6.3695F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(113, 55).addBox(-2.0F, -0.9914F, -8.1695F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -15.3362F, 1.6232F));

		PartDefinition chest_r1 = head.addOrReplaceChild("chest_r1", CubeListBuilder.create().texOffs(13, 113).addBox(-1.0F, -0.5F, -1.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.15F, -1.9914F, -7.1695F, -0.5149F, 0.0F, 1.5708F));

		PartDefinition chest_r2 = head.addOrReplaceChild("chest_r2", CubeListBuilder.create().texOffs(112, 102).addBox(-2.0F, -0.5F, -1.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.15F, -1.9914F, -7.1695F, -0.5149F, 0.0F, -1.5708F));

		PartDefinition chest_r3 = head.addOrReplaceChild("chest_r3", CubeListBuilder.create().texOffs(113, 59).addBox(-2.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.7709F, -7.3787F, 0.2705F, 0.0F, 0.0F));

		PartDefinition chest_r4 = head.addOrReplaceChild("chest_r4", CubeListBuilder.create().texOffs(112, 96).addBox(-2.0F, -1.5F, -1.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5914F, -7.3695F, 0.0873F, 0.0F, 0.0F));

		PartDefinition leftear = head.addOrReplaceChild("leftear", CubeListBuilder.create().texOffs(0, 83).addBox(-2.0F, -11.5462F, -2.3434F, 4.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -8.6538F, 1.3434F, -0.9319F, 0.169F, 0.1243F));

		PartDefinition cube_r1 = leftear.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(15, 84).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.4462F, 1.1566F, 0.2443F, 0.0F, 0.0F));

		PartDefinition rightear = head.addOrReplaceChild("rightear", CubeListBuilder.create().texOffs(30, 84).addBox(-2.0F, -11.5462F, -2.3434F, 4.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -8.6538F, 1.3434F, -0.9319F, -0.169F, -0.1243F));

		PartDefinition cube_r2 = rightear.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(69, 89).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.4462F, 1.1566F, 0.2443F, 0.0F, 0.0F));

		PartDefinition neck = bdoywhole.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(76, 45).addBox(-2.5F, -3.5F, -2.5F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -14.8362F, 1.1232F));

		PartDefinition chest = bdoywhole.addOrReplaceChild("chest", CubeListBuilder.create(), PartPose.offset(0.0F, 0.6724F, -0.7463F));

		PartDefinition top = chest.addOrReplaceChild("top", CubeListBuilder.create(), PartPose.offset(0.0F, -9.0F, 0.5F));

		PartDefinition chest_r5 = top.addOrReplaceChild("chest_r5", CubeListBuilder.create().texOffs(0, 24).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition arms = top.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(0.0F, 30.7914F, -0.6305F));

		PartDefinition leftarm = arms.addOrReplaceChild("leftarm", CubeListBuilder.create(), PartPose.offset(7.5F, -33.0F, 1.5F));

		PartDefinition toparm2 = leftarm.addOrReplaceChild("toparm2", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.7F, -1.5F, 0.4F, -0.0004F, -0.0959F, 1.3962F));

		PartDefinition cube_r3 = toparm2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(106, 109).addBox(-0.5F, -0.5F, -3.5F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3151F, 0.3975F, 0.9352F, 0.0F, 0.0F, -2.6791F));

		PartDefinition cube_r4 = toparm2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(103, 20).addBox(-1.0F, -6.0F, -2.0F, 3.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0151F, -0.4025F, -0.0648F, 0.0873F, 0.0F, -1.5708F));

		PartDefinition cube_r5 = toparm2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(84, 102).addBox(-1.0F, -6.0F, -1.0F, 3.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0151F, -0.4025F, 0.4352F, 0.0F, 0.0F, -1.5708F));

		PartDefinition bottomarm2 = toparm2.addOrReplaceChild("bottomarm2", CubeListBuilder.create(), PartPose.offsetAndRotation(9.7151F, -0.9025F, 1.0352F, -0.0285F, 1.3005F, 0.0595F));

		PartDefinition cube_r6 = bottomarm2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(66, 16).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5019F, 0.5347F, -1.1325F, -0.4515F, 0.0F, -1.5703F));

		PartDefinition cube_r7 = bottomarm2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(41, 108).addBox(-1.0F, 0.2279F, -1.1448F, 3.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1019F, 0.5347F, -2.6825F, 0.1134F, 0.0F, -1.5708F));

		PartDefinition cube_r8 = bottomarm2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(30, 101).addBox(-1.0F, -5.0F, -1.0F, 3.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1019F, 0.5347F, -0.7825F, -0.0436F, 0.0F, -1.5708F));

		PartDefinition hand2 = bottomarm2.addOrReplaceChild("hand2", CubeListBuilder.create().texOffs(101, 84).addBox(-1.2659F, 0.6404F, -2.0444F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.7019F, -0.0153F, -1.5825F, 1.5124F, -1.1241F, 0.1593F));

		PartDefinition cube_r9 = hand2.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(97, 48).addBox(-2.0F, -3.0F, -2.0F, 5.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3341F, 1.8404F, -0.0444F, 0.0F, 0.0F, 0.2094F));

		PartDefinition rightarm = arms.addOrReplaceChild("rightarm", CubeListBuilder.create(), PartPose.offset(-7.5F, -33.0F, 1.5F));

		PartDefinition toparm3 = rightarm.addOrReplaceChild("toparm3", CubeListBuilder.create(), PartPose.offsetAndRotation(2.7F, -1.5F, 0.4F, -0.0004F, 0.0959F, -1.3962F));

		PartDefinition cube_r10 = toparm3.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 112).addBox(-1.5F, -0.5F, -3.5F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3151F, 0.3975F, 0.9352F, 0.0F, 0.0F, 2.6791F));

		PartDefinition cube_r11 = toparm3.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(73, 106).addBox(-2.0F, -6.0F, -2.0F, 3.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0151F, -0.4025F, -0.0648F, 0.0873F, 0.0F, 1.5708F));

		PartDefinition cube_r12 = toparm3.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(62, 106).addBox(-2.0F, -6.0F, -1.0F, 3.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0151F, -0.4025F, 0.4352F, 0.0F, 0.0F, 1.5708F));

		PartDefinition bottomarm3 = toparm3.addOrReplaceChild("bottomarm3", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.7151F, -0.9025F, 0.0352F, -0.0285F, -1.3005F, -0.0595F));

		PartDefinition cube_r13 = bottomarm3.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(113, 63).addBox(-2.0F, -1.0F, -2.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8048F, 0.4403F, 0.0943F, -0.4515F, 0.0F, 1.5703F));

		PartDefinition cube_r14 = bottomarm3.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(95, 109).addBox(-2.0F, 0.2279F, -1.1448F, 3.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4048F, 0.4403F, -1.4557F, 0.1134F, 0.0F, 1.5708F));

		PartDefinition cube_r15 = bottomarm3.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(101, 96).addBox(-2.0F, -5.0F, -1.0F, 3.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4048F, 0.4403F, 0.4443F, -0.0436F, 0.0F, 1.5708F));

		PartDefinition hand3 = bottomarm3.addOrReplaceChild("hand3", CubeListBuilder.create().texOffs(101, 90).addBox(-3.7341F, 0.6404F, -2.0444F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0048F, -0.1097F, -0.3557F, 1.5124F, 1.1241F, -0.1593F));

		PartDefinition cube_r16 = hand3.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(101, 13).addBox(-3.0F, -3.0F, -2.0F, 5.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3341F, 1.8404F, -0.0444F, 0.0F, 0.0F, -0.2094F));

		PartDefinition bottom = chest.addOrReplaceChild("bottom", CubeListBuilder.create(), PartPose.offset(-0.5F, -2.0F, 1.0F));

		PartDefinition chest_r6 = bottom.addOrReplaceChild("chest_r6", CubeListBuilder.create().texOffs(39, 45).addBox(-4.0F, -4.0F, -5.0F, 9.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition rightleg = bottom.addOrReplaceChild("rightleg", CubeListBuilder.create(), PartPose.offsetAndRotation(0.8F, -2.0F, 0.0F, 0.0F, -0.1047F, 0.0F));

		PartDefinition topleg = rightleg.addOrReplaceChild("topleg", CubeListBuilder.create().texOffs(0, 65).addBox(-1.6815F, -0.41F, -4.2178F, 6.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.1612F, 5.7477F, 0.3758F, -0.094F, 0.2566F, 0.0413F));

		PartDefinition cube_r17 = topleg.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(50, 66).addBox(-3.0F, -3.0F, -4.5F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9185F, 0.0034F, 0.3046F, 0.0F, 0.0F, 0.7156F));

		PartDefinition cube_r18 = topleg.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(78, 0).addBox(-3.0F, -8.0F, -1.5F, 6.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3185F, 7.1034F, 1.2046F, -0.2007F, -0.0007F, -0.0001F));

		PartDefinition middle = topleg.addOrReplaceChild("middle", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 10.5F, -2.9F, 0.0523F, 0.0027F, -0.0523F));

		PartDefinition cube_r19 = middle.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(84, 89).addBox(-2.0F, -2.0F, -4.0F, 5.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8185F, -2.4161F, 2.7917F, 1.0123F, 0.0F, 0.0F));

		PartDefinition cube_r20 = middle.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(45, 95).addBox(-2.0F, -2.0F, -5.0F, 5.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8185F, -4.3161F, 4.3917F, 0.8901F, 0.0F, 0.0F));

		PartDefinition bottomleg = middle.addOrReplaceChild("bottomleg", CubeListBuilder.create(), PartPose.offsetAndRotation(1.3685F, 2.1845F, 5.0878F, 0.061F, 0.0021F, -0.0348F));

		PartDefinition cube_r21 = bottomleg.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 100).addBox(-1.0F, -1.6126F, -0.0974F, 5.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 0.8994F, 0.9039F, -0.4189F, 0.0F, 0.0F));

		PartDefinition cube_r22 = bottomleg.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(96, 58).addBox(-1.0F, -1.6126F, -2.0974F, 5.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 0.8994F, 0.1039F, -0.2443F, 0.0F, 0.0F));

		PartDefinition foot = bottomleg.addOrReplaceChild("foot", CubeListBuilder.create().texOffs(78, 15).addBox(-2.5F, -0.5F, -4.6F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.9F, -1.8F));

		PartDefinition cube_r23 = foot.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(47, 16).addBox(-2.0F, -2.0F, -5.0F, 5.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -0.3F, 0.4F, 0.3316F, 0.0F, 0.0F));

		PartDefinition leftleg = bottom.addOrReplaceChild("leftleg", CubeListBuilder.create(), PartPose.offsetAndRotation(0.2F, -2.0F, 0.0F, 0.0F, 0.1047F, 0.0F));

		PartDefinition topleg2 = leftleg.addOrReplaceChild("topleg2", CubeListBuilder.create().texOffs(25, 66).addBox(-4.3185F, -0.41F, -4.2178F, 6.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1612F, 5.7477F, 0.3758F, -0.094F, -0.2566F, -0.0413F));

		PartDefinition cube_r24 = topleg2.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(73, 66).addBox(0.0F, -3.0F, -4.5F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9185F, 0.0034F, 0.3046F, 0.0F, 0.0F, -0.7156F));

		PartDefinition cube_r25 = topleg2.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(50, 80).addBox(-3.0F, -8.0F, -1.5F, 6.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3185F, 7.1034F, 1.2046F, -0.2007F, 0.0007F, 0.0001F));

		PartDefinition middle2 = topleg2.addOrReplaceChild("middle2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 9.4F, -2.1F, 0.0523F, -0.0027F, 0.0523F));

		PartDefinition cube_r26 = middle2.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(97, 0).addBox(-3.0F, -2.0F, -4.0F, 5.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7632F, -1.3609F, 1.9353F, 1.0123F, 0.0F, 0.0F));

		PartDefinition cube_r27 = middle2.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(96, 71).addBox(-3.0F, -2.0F, -5.0F, 5.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7632F, -3.2609F, 3.5353F, 0.8901F, 0.0F, 0.0F));

		PartDefinition bottomleg2 = middle2.addOrReplaceChild("bottomleg2", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.3132F, 3.2397F, 4.2313F, 0.061F, -0.0021F, 0.0348F));

		PartDefinition cube_r28 = bottomleg2.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(15, 101).addBox(-4.0F, -1.6126F, -0.0974F, 5.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.8994F, 0.9039F, -0.4189F, 0.0F, 0.0F));

		PartDefinition cube_r29 = bottomleg2.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(97, 35).addBox(-4.0F, -1.6126F, -2.0974F, 5.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.8994F, 0.1039F, -0.2443F, 0.0F, 0.0F));

		PartDefinition foot2 = bottomleg2.addOrReplaceChild("foot2", CubeListBuilder.create().texOffs(69, 80).addBox(-2.5F, -0.2F, -4.9F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.6F, -1.5F));

		PartDefinition cube_r30 = foot2.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(76, 58).addBox(-3.0F, -2.0F, -5.0F, 5.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.1F, 0.3316F, 0.0F, 0.0F));

		PartDefinition tail = bottom.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(1.4926F, 1.8323F, 1.1636F));

		PartDefinition cube_r31 = tail.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -3.0F, 9.0F, 9.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -0.25F, 1.0F, -0.6545F, 0.0F, 0.0F));

		PartDefinition tail1 = tail.addOrReplaceChild("tail1", CubeListBuilder.create(), PartPose.offset(-1.0F, 5.75F, 9.0F));

		PartDefinition cube_r32 = tail1.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(0, 45).addBox(-4.0F, -3.8369F, -2.0027F, 8.0F, 8.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.7163F, 0.0647F, -0.829F, 0.0F, 0.0F));

		PartDefinition tail2 = tail1.addOrReplaceChild("tail2", CubeListBuilder.create(), PartPose.offset(0.3074F, 6.5454F, 5.2827F));

		PartDefinition cube_r33 = tail2.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(47, 0).addBox(-3.0F, -2.8107F, -0.7755F, 6.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3074F, 0.5709F, -0.0179F, -0.6981F, 0.0F, 0.0F));

		PartDefinition tail3 = tail2.addOrReplaceChild("tail3", CubeListBuilder.create(), PartPose.offset(-0.3F, 5.6F, 5.1F));

		PartDefinition cube_r34 = tail3.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(82, 24).addBox(-1.0F, 0.1631F, 0.9973F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9074F, -2.2291F, -0.2179F, -0.3491F, 0.0F, 0.0F));

		PartDefinition tail4 = tail3.addOrReplaceChild("tail4", CubeListBuilder.create(), PartPose.offset(0.0F, 2.1F, 4.8F));

		PartDefinition cube_r35 = tail4.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(82, 35).addBox(-1.0F, -1.3139F, -0.9684F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4074F, 0.1709F, 1.4821F, -0.2618F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(VoidSlugcatEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch);

		this.animateWalk(VoidAnimations.walking, limbSwing, limbSwingAmount, 2f, 1f);
		this.animate(entity.idleAnimationState, VoidAnimations.idle, ageInTicks, 1f);
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