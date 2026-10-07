package net.fot.fotslugcats.entity.client;// Made with Blockbench 5.2.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.fot.fotslugcats.FoTSlugcats;
import net.fot.fotslugcats.entity.custom.HunterSlugcatEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class HunterModel<T extends HunterSlugcatEntity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID, "hunter"), "main");
	private final ModelPart bdoywhole;
	private final ModelPart headbone;
	private final ModelPart head2;
	private final ModelPart leftear;
	private final ModelPart leftear2;
	private final ModelPart rightear;
	private final ModelPart rightear2;
	private final ModelPart neck;
	private final ModelPart chest;
	private final ModelPart topchest;
	private final ModelPart royt;
	private final ModelPart bottomchest;
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
	private final ModelPart tailbone;
	private final ModelPart tail;
	private final ModelPart tail1;
	private final ModelPart tail2;
	private final ModelPart tail3;
	private final ModelPart tail4;

	public HunterModel(ModelPart root) {
		this.bdoywhole = root.getChild("bdoywhole");
		this.headbone = this.bdoywhole.getChild("headbone");
		this.head2 = this.headbone.getChild("head2");
		this.leftear = this.head2.getChild("leftear");
		this.leftear2 = this.leftear.getChild("leftear2");
		this.rightear = this.head2.getChild("rightear");
		this.rightear2 = this.rightear.getChild("rightear2");
		this.neck = this.bdoywhole.getChild("neck");
		this.chest = this.bdoywhole.getChild("chest");
		this.topchest = this.chest.getChild("topchest");
		this.royt = this.topchest.getChild("royt");
		this.bottomchest = this.chest.getChild("bottomchest");
		this.rightleg = this.bottomchest.getChild("rightleg");
		this.topleg = this.rightleg.getChild("topleg");
		this.middle = this.topleg.getChild("middle");
		this.bottomleg = this.middle.getChild("bottomleg");
		this.foot = this.bottomleg.getChild("foot");
		this.leftleg = this.bottomchest.getChild("leftleg");
		this.topleg2 = this.leftleg.getChild("topleg2");
		this.middle2 = this.topleg2.getChild("middle2");
		this.bottomleg2 = this.middle2.getChild("bottomleg2");
		this.foot2 = this.bottomleg2.getChild("foot2");
		this.tailbone = this.bottomchest.getChild("tailbone");
		this.tail = this.tailbone.getChild("tail");
		this.tail1 = this.tail.getChild("tail1");
		this.tail2 = this.tail1.getChild("tail2");
		this.tail3 = this.tail2.getChild("tail3");
		this.tail4 = this.tail3.getChild("tail4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bdoywhole = partdefinition.addOrReplaceChild("bdoywhole", CubeListBuilder.create(), PartPose.offset(0.0F, 0.5362F, 0.8768F));

		PartDefinition headbone = bdoywhole.addOrReplaceChild("headbone", CubeListBuilder.create(), PartPose.offset(0.0F, -16.3362F, -0.8768F));

		PartDefinition head2 = headbone.addOrReplaceChild("head2", CubeListBuilder.create().texOffs(41, 24).addBox(-5.0F, -9.9914F, -6.3695F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(84, 102).addBox(-2.0F, -0.9914F, -8.1695F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.5F, 0.2269F, 0.0F, 0.2182F));

		PartDefinition chest_r1 = head2.addOrReplaceChild("chest_r1", CubeListBuilder.create().texOffs(82, 38).addBox(-1.0F, -0.5F, -1.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.15F, -1.9914F, -7.1695F, -0.5149F, 0.0F, 1.5708F));

		PartDefinition chest_r2 = head2.addOrReplaceChild("chest_r2", CubeListBuilder.create().texOffs(82, 33).addBox(-2.0F, -0.5F, -1.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.15F, -1.9914F, -7.1695F, -0.5149F, 0.0F, -1.5708F));

		PartDefinition chest_r3 = head2.addOrReplaceChild("chest_r3", CubeListBuilder.create().texOffs(103, 21).addBox(-2.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.7709F, -7.3787F, 0.2705F, 0.0F, 0.0F));

		PartDefinition chest_r4 = head2.addOrReplaceChild("chest_r4", CubeListBuilder.create().texOffs(76, 60).addBox(-2.0F, -1.5F, -1.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5914F, -7.3695F, 0.0873F, 0.0F, 0.0F));

		PartDefinition leftear = head2.addOrReplaceChild("leftear", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, -8.6538F, 1.3434F, -0.9319F, 0.169F, 0.1243F));

		PartDefinition leftear2 = leftear.addOrReplaceChild("leftear2", CubeListBuilder.create().texOffs(30, 84).addBox(-2.0F, -11.5462F, -2.3434F, 4.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6352F, 0.169F, 0.1243F));

		PartDefinition cube_r1 = leftear2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(69, 89).addBox(-2.0F, -11.2063F, 0.2918F, 4.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.1599F, 0.1924F, 0.2443F, 0.0F, 0.0F));

		PartDefinition rightear = head2.addOrReplaceChild("rightear", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, -8.6538F, 1.3434F, -0.9319F, -0.169F, -0.1243F));

		PartDefinition rightear2 = rightear.addOrReplaceChild("rightear2", CubeListBuilder.create().texOffs(0, 83).addBox(-2.0F, -11.5462F, -2.3434F, 4.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.9793F, -0.2941F, -0.2219F));

		PartDefinition cube_r2 = rightear2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(15, 84).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.4462F, 1.1566F, 0.2443F, 0.0F, 0.0F));

		PartDefinition neck = bdoywhole.addOrReplaceChild("neck", CubeListBuilder.create(), PartPose.offset(0.0F, -14.6403F, -0.8709F));

		PartDefinition cube_r3 = neck.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(78, 0).addBox(-3.0F, -5.0F, -3.0F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 1.3041F, 0.8941F, 0.2793F, 0.0F, 0.0F));

		PartDefinition chest = bdoywhole.addOrReplaceChild("chest", CubeListBuilder.create(), PartPose.offset(0.0F, 0.6724F, -0.7463F));

		PartDefinition topchest = chest.addOrReplaceChild("topchest", CubeListBuilder.create(), PartPose.offset(0.0F, -9.0F, -0.1F));

		PartDefinition chest_r5 = topchest.addOrReplaceChild("chest_r5", CubeListBuilder.create().texOffs(0, 24).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.122F, 0.0064F, -0.052F));

		PartDefinition royt = topchest.addOrReplaceChild("royt", CubeListBuilder.create(), PartPose.offset(1.2F, -2.2F, 5.5F));

		PartDefinition chest_r6 = royt.addOrReplaceChild("chest_r6", CubeListBuilder.create().texOffs(66, 16).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8083F, 0.364F, -0.5202F, -0.631F, 0.1598F, -1.37F));

		PartDefinition chest_r7 = royt.addOrReplaceChild("chest_r7", CubeListBuilder.create().texOffs(101, 93).addBox(-1.5F, -1.5F, -2.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0889F, 2.2224F, -0.2776F, -0.6501F, 0.5311F, -0.526F));

		PartDefinition chest_r8 = royt.addOrReplaceChild("chest_r8", CubeListBuilder.create().texOffs(101, 101).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8F, 2.0F, 0.0F, -0.0518F, -0.3405F, -0.48F));

		PartDefinition chest_r9 = royt.addOrReplaceChild("chest_r9", CubeListBuilder.create().texOffs(101, 12).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.28F, 0.3427F, -0.2627F));

		PartDefinition bottomchest = chest.addOrReplaceChild("bottomchest", CubeListBuilder.create(), PartPose.offset(0.449F, -3.1981F, 3.2147F));

		PartDefinition chest_r10 = bottomchest.addOrReplaceChild("chest_r10", CubeListBuilder.create().texOffs(39, 45).addBox(-4.0F, -4.0F, -5.0F, 9.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.949F, 1.1981F, -2.2147F, 0.0694F, -0.0073F, 0.1045F));

		PartDefinition rightleg = bottomchest.addOrReplaceChild("rightleg", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.149F, -0.8019F, -2.2147F, 0.0F, -0.1047F, 0.0F));

		PartDefinition topleg = rightleg.addOrReplaceChild("topleg", CubeListBuilder.create().texOffs(0, 65).addBox(-1.6815F, -0.41F, -4.2178F, 6.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.1612F, 4.3478F, 0.3758F, 0.0451F, 0.2697F, 0.2396F));

		PartDefinition cube_r4 = topleg.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(50, 66).addBox(-3.0F, -3.0F, -4.5F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9185F, 0.0034F, 0.3046F, 0.0F, 0.0F, 0.7156F));

		PartDefinition cube_r5 = topleg.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(76, 45).addBox(-3.0F, -8.0F, -1.5F, 6.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3185F, 7.1034F, 1.2046F, -0.2007F, -0.0007F, -0.0001F));

		PartDefinition middle = topleg.addOrReplaceChild("middle", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 10.5F, -2.9F, -0.2614F, 0.0073F, 0.0349F));

		PartDefinition cube_r6 = middle.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(95, 33).addBox(-2.0F, -2.0F, -4.0F, 5.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8185F, -2.4161F, 2.7917F, 1.0123F, 0.0F, 0.0F));

		PartDefinition cube_r7 = middle.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(84, 89).addBox(-2.0F, -2.0F, -5.0F, 5.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8185F, -4.3161F, 4.3917F, 0.8901F, 0.0F, 0.0F));

		PartDefinition bottomleg = middle.addOrReplaceChild("bottomleg", CubeListBuilder.create(), PartPose.offsetAndRotation(1.3685F, 2.1845F, 5.0878F, 0.5323F, 0.0021F, -0.0348F));

		PartDefinition cube_r8 = bottomleg.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 100).addBox(-1.0F, -1.6126F, -0.0974F, 5.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 0.8994F, 0.9039F, -0.4189F, 0.0F, 0.0F));

		PartDefinition cube_r9 = bottomleg.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(96, 59).addBox(-1.0F, -1.6126F, -2.0974F, 5.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 0.8994F, 0.1039F, -0.2443F, 0.0F, 0.0F));

		PartDefinition foot = bottomleg.addOrReplaceChild("foot", CubeListBuilder.create().texOffs(78, 13).addBox(-2.5F, -0.6156F, -4.4189F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0156F, -1.9811F, -0.2618F, 0.0F, -0.2618F));

		PartDefinition cube_r10 = foot.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(47, 16).addBox(-2.0F, -2.0F, -5.0F, 5.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -0.4156F, 0.5811F, 0.3316F, 0.0F, 0.0F));

		PartDefinition leftleg = bottomchest.addOrReplaceChild("leftleg", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.749F, -0.8019F, -2.2147F, 0.0F, 0.1047F, 0.0F));

		PartDefinition topleg2 = leftleg.addOrReplaceChild("topleg2", CubeListBuilder.create().texOffs(25, 66).addBox(-4.3185F, -0.41F, -4.2178F, 6.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1612F, 6.5478F, 0.3758F, -0.2372F, -0.2611F, -0.0952F));

		PartDefinition cube_r11 = topleg2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(73, 66).addBox(0.0F, -3.0F, -4.5F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9185F, 0.0034F, 0.3046F, 0.0F, 0.0F, -0.7156F));

		PartDefinition cube_r12 = topleg2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(50, 80).addBox(-3.0F, -8.0F, -1.5F, 6.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3185F, 7.1034F, 1.2046F, -0.2007F, 0.0007F, 0.0001F));

		PartDefinition middle2 = topleg2.addOrReplaceChild("middle2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 10.5F, -2.9F, -0.0524F, -0.0027F, 0.0523F));

		PartDefinition cube_r13 = middle2.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(95, 46).addBox(-3.0F, -2.0F, -4.0F, 5.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8185F, -2.416F, 2.7917F, 1.0123F, 0.0F, 0.0F));

		PartDefinition cube_r14 = middle2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(96, 72).addBox(-3.0F, -2.0F, -5.0F, 5.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8185F, -4.316F, 4.3917F, 0.8901F, 0.0F, 0.0F));

		PartDefinition bottomleg2 = middle2.addOrReplaceChild("bottomleg2", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.3685F, 2.1845F, 5.0878F, -0.1658F, -0.0021F, 0.0348F));

		PartDefinition cube_r15 = bottomleg2.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(99, 0).addBox(-4.0F, -1.6126F, -0.0974F, 5.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.8994F, 0.9039F, -0.4189F, 0.0F, 0.0F));

		PartDefinition cube_r16 = bottomleg2.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(45, 95).addBox(-4.0F, -1.6126F, -2.0974F, 5.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.8994F, 0.1039F, -0.2443F, 0.0F, 0.0F));

		PartDefinition foot2 = bottomleg2.addOrReplaceChild("foot2", CubeListBuilder.create().texOffs(69, 80).addBox(-2.5F, -0.6156F, -5.5189F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0156F, -0.8811F, 0.4712F, 0.0F, 0.0F));

		PartDefinition cube_r17 = foot2.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(15, 101).addBox(-3.0F, -2.0F, -5.0F, 5.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -0.4156F, -0.5189F, 0.3316F, 0.0F, 0.0F));

		PartDefinition tailbone = bottomchest.addOrReplaceChild("tailbone", CubeListBuilder.create(), PartPose.offset(3.5436F, 26.0304F, -1.051F));

		PartDefinition tail = tailbone.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.25F, -21.8341F, 2.4345F, 0.0F, 0.3054F, 0.0F));

		PartDefinition cube_r18 = tail.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -3.0F, 9.0F, 9.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -1.4159F, -1.4345F, -0.6545F, 0.0F, 0.0F));

		PartDefinition tail1 = tail.addOrReplaceChild("tail1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.55F, 5.9841F, 8.4655F, -0.0324F, 0.2595F, -0.1444F));

		PartDefinition cube_r19 = tail1.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 45).addBox(-4.0F, -3.8369F, -2.0027F, 8.0F, 8.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4F, -0.6837F, -1.8353F, -0.829F, 0.0F, 0.0F));

		PartDefinition tail2 = tail1.addOrReplaceChild("tail2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.3074F, 5.8454F, 4.0827F, -0.1547F, -0.6606F, 0.1658F));

		PartDefinition cube_r20 = tail2.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(47, 0).addBox(-3.0F, -1.8369F, -1.0027F, 6.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4074F, -1.8291F, 0.0821F, -0.6981F, 0.0F, 0.0F));

		PartDefinition tail3 = tail2.addOrReplaceChild("tail3", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.2F, 4.1F, 6.0F, 0.0F, -0.4538F, 0.0F));

		PartDefinition cube_r21 = tail3.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(82, 22).addBox(-1.0F, 0.1631F, 0.9973F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1074F, -2.5291F, -1.8179F, -0.3491F, 0.0F, 0.0F));

		PartDefinition tail4 = tail3.addOrReplaceChild("tail4", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.2F, 1.7F, 4.3F, 0.0F, -0.6109F, 0.0F));

		PartDefinition cube_r22 = tail4.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(100, 84).addBox(-1.0F, -1.3139F, -1.9684F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4074F, 0.2709F, 0.3821F, -0.2618F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(HunterSlugcatEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch);

		this.animateWalk(HunterAnimations.walking2, limbSwing, limbSwingAmount, 2f, 1f);
		this.animate(entity.idleAnimationState, HunterAnimations.idle, ageInTicks, 1f);
	}

	private void applyHeadRotation(float headYaw, float headPitch) {
		headYaw = Mth.clamp(headYaw, -30f, 30f);
		headPitch = Mth.clamp(headPitch, -25f, 45f);

		this.headbone.yRot = headYaw * ((float)Mth.PI / 180f);
		this.headbone.xRot = headPitch * ((float)Mth.PI / 180f);
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