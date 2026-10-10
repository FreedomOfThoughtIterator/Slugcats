package net.fot.fotslugcats.entity.custom;

import net.fot.fotslugcats.entity.ModEntities;
import net.fot.fotslugcats.entity.SlugcatState;
import net.fot.fotslugcats.item.ModItems;
import net.fot.fotslugcats.sound.ModSounds;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.AABB;
import net.neoforged.neoforge.event.EventHooks;
import org.jetbrains.annotations.Nullable;

import java.lang.constant.Constable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

public class SlugcatEntity extends TamableAnimal implements RangedAttackMob {

    public final AnimationState idleAnimationState = new AnimationState();
    public int idleAnimationTimeout = 0;
    public final AnimationState sitAnimationState = new AnimationState();

    /* ASB (Advanced Slugcat Behaviours) variables and methods */
    public int internalTickTimer = 0;
    public static final EntityDataAccessor<Integer> INTERNALTICKTIMER =
            SynchedEntityData.defineId(SlugcatEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> HUNGER =
            SynchedEntityData.defineId(SlugcatEntity.class, EntityDataSerializers.INT);

    public int hunger = 20;
    public SlugcatState state = SlugcatState.NORMAL;

    private int getInternalTickTimer() {
        return this.entityData.get(INTERNALTICKTIMER);
    }

    private int getHunger() {
        return this.entityData.get(HUNGER);
    }

    private void incrementInternalTickTimer() {
        this.entityData.set(INTERNALTICKTIMER, getInternalTickTimer() + 1);
    }

    private void decrementHunger() {
        this.entityData.set(HUNGER, getHunger() - 1);
    }

    private void setInternalTickTimer(Integer value) {
        this.entityData.set(INTERNALTICKTIMER, value);
    }

    private void setHunger(Integer value) {
        this.entityData.set(HUNGER, value);
    }


    public Map<Integer, Supplier<? extends EntityType<? extends SlugcatEntity>>> scugs =
            Map.of(
                    0, ModEntities.SLUGCAT,
                    1, ModEntities.MONK,
                    2, ModEntities.SURVIVOR,
                    3, ModEntities.HUNTER
            );

    public SlugcatEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(INTERNALTICKTIMER, 0).define(HUNGER, 20);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, true));
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.0));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this).setAlertOthers());
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.2, Ingredient.of(ModItems.BLUEFRUIT.get()), false));
        this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.25));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, (float) 10));

        this.targetSelector.addGoal(6, new OwnerHurtTargetGoal(this));
        this.goalSelector.addGoal(7, new FollowOwnerGoal(this, 1, (float) 10, (float) 2));

        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(2, new FloatGoal(this));
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25, 20, 10f));
    }

    @Override
    public void performRangedAttack(LivingEntity livingEntity, float v) {
        Arrow entityarrow = new Arrow(this.level(), this, new ItemStack(Items.ARROW), null);
        double d0 = livingEntity.getY() + livingEntity.getEyeHeight() - 1.1;
        double d1 = livingEntity.getX() - this.getX();
        double d3 = livingEntity.getZ() - this.getZ();
        entityarrow.shoot(d1, d0 - entityarrow.getY() + Math.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 1.6F, 12.0F);
        this.level().addFreshEntity(entityarrow);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return TamableAnimal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 10d)
                .add(Attributes.MOVEMENT_SPEED, 0.3d)
                .add(Attributes.FOLLOW_RANGE, 64d)
                .add(Attributes.ATTACK_DAMAGE, 3d)
                .add(Attributes.STEP_HEIGHT, 0.6f)
        ;
    }

    protected void dropCustomDeathLoot(ServerLevel serverLevel, DamageSource source, boolean recentlyHitIn) {
        super.dropCustomDeathLoot(serverLevel, source, recentlyHitIn);
        this.spawnAtLocation(new ItemStack(ModItems.SLUGMEAT.get()));
    }

    @Override
    public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
        ItemStack itemstack = sourceentity.getItemInHand(hand);
        InteractionResult retval = InteractionResult.sidedSuccess(this.level().isClientSide());
        Item item = itemstack.getItem();
        if (itemstack.getItem() instanceof SpawnEggItem) {
            retval = super.mobInteract(sourceentity, hand);
        } else if (this.level().isClientSide()) {
            retval = (this.isTame() && this.isOwnedBy(sourceentity) || this.isFood(itemstack)) ? InteractionResult.sidedSuccess(this.level().isClientSide()) : InteractionResult.PASS;
        } else {
            if (this.isTame()) {
                if (this.isOwnedBy(sourceentity)) {
                    if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
                        this.usePlayerItem(sourceentity, hand, itemstack);
                        FoodProperties foodproperties = itemstack.getFoodProperties(this);
                        float nutrition = foodproperties != null ? (float) foodproperties.nutrition() : 1;
                        this.heal(nutrition);
                        retval = InteractionResult.sidedSuccess(this.level().isClientSide());
                    } else if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
                        this.usePlayerItem(sourceentity, hand, itemstack);
                        this.heal(4);
                        retval = InteractionResult.sidedSuccess(this.level().isClientSide());
                    } else {
                        retval = super.mobInteract(sourceentity, hand);
                    }
                }
            } else if (this.isFood(itemstack)) {
                this.usePlayerItem(sourceentity, hand, itemstack);
                if (this.random.nextInt(3) == 0 && !EventHooks.onAnimalTame(this, sourceentity)) {
                    this.tame(sourceentity);
                    this.level().broadcastEntityEvent(this, (byte) 7);
                } else {
                    this.level().broadcastEntityEvent(this, (byte) 6);
                }
                this.setPersistenceRequired();
                retval = InteractionResult.sidedSuccess(this.level().isClientSide());
            } else {
                retval = super.mobInteract(sourceentity, hand);
                if (retval == InteractionResult.SUCCESS || retval == InteractionResult.CONSUME)
                    this.setPersistenceRequired();
            }
        }
        return retval;
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(ModItems.BLUEFRUIT.get());
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        int weightedRandom = Mth.nextInt(RandomSource.create(), 0, 101);
        int scug = 0;
        if (80 <= weightedRandom && weightedRandom <= 101) {
            scug = Mth.nextInt(RandomSource.create(), 1, 4);
        }
        Supplier<? extends EntityType<? extends SlugcatEntity>> slugSpawn = scugs.get(scug);
        return slugSpawn.get().create(serverLevel);
    }

    private void setupAnimationStates() {
        if(this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 70;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getInternalTickTimer() >= 600) {
            if (this.state != SlugcatState.STARVING) {
                if (this.hunger == 0) {
                    this.state = SlugcatState.HUNGRY;
                } else {
                    --this.hunger;
                    this.setInternalTickTimer(0);
                }
                System.out.println(this.hunger);
            }
        }
        if (this.getInternalTickTimer() >= 6000 && this.state == SlugcatState.STARVING) {
            this.kill();
        }
        if (this.getInternalTickTimer() >= 12000) {
            this.state = SlugcatState.STARVING;
            this.setInternalTickTimer(0);
        }

        if(this.level().isClientSide()) {
            this.setupAnimationStates();
        } else {
            this.incrementInternalTickTimer();
            System.out.println(this.internalTickTimer);
        }
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @javax.annotation.Nullable SpawnGroupData spawnGroupData) {
        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    }

    /* SOUNDS */

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return this.isBaby() ? ModSounds.slugpupmeow.get() : ModSounds.slugcatmeow.get();
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource damageSource) {
        return this.isBaby() ? ModSounds.slugpupcry.get() : ModSounds.slugcathit.get();
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return ModSounds.slugcathit.get();
    }

    @Override
    public float getVoicePitch() {
        return (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F;
    }
}
