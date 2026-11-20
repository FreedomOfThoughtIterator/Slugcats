package net.fot.fotslugcats.entity.custom;

import net.fot.fotslugcats.entity.ModEntities;
import net.fot.fotslugcats.entity.SlugcatState;
import net.fot.fotslugcats.entity.goals.EatCropGoal;
import net.fot.fotslugcats.item.ModItems;
import net.fot.fotslugcats.sound.ModSounds;
import net.fot.fotslugcats.util.ModTags;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
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
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.animal.*;
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
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Supplier;

@EventBusSubscriber
public class SlugcatEntity extends TamableAnimal implements RangedAttackMob {

    public final AnimationState idleAnimationState = new AnimationState();
    public int idleAnimationTimeout = 0;
    public final AnimationState sitAnimationState = new AnimationState();
    public int loafAnimationTimeout = 0;
    private static final int EAT_ANIMATION_TICKS = 40;
    private int eatAnimationTick;
    private EatCropGoal eatCropGoal;

    /* ASB (Advanced Slugcat Behaviours) variables and methods */
    public static final EntityDataAccessor<Integer> INTERNALTICKTIMER =
            SynchedEntityData.defineId(SlugcatEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> HUNGER =
            SynchedEntityData.defineId(SlugcatEntity.class, EntityDataSerializers.INT);

    public SlugcatState state = SlugcatState.NORMAL;

    private int getInternalTickTimer() {
        return this.entityData.get(INTERNALTICKTIMER);
    }

    private int getHunger() {
        return this.entityData.get(HUNGER);
    }

    private int getMaxHunger() {
        return 20;
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

    @SubscribeEvent
    public static void EatAnimal(LivingDeathEvent event) {
        Entity source = event.getSource().getEntity();
        Entity entity = event.getEntity();
        int hungerIncrement = 1;

        if (source instanceof SlugcatEntity slugcat) {
            System.out.println("Slugcat killed " + entity);
            System.out.println("Slugcat " + slugcat);
            System.out.println(slugcat.getHunger());
            if (entity instanceof Animal) {
                switch (entity) {
                    case Cow cow -> hungerIncrement = 6;
                    case Chicken chicken -> hungerIncrement = 4;
                    case Sheep sheep -> hungerIncrement = 4;
                    case Pig pig -> hungerIncrement = 5;
                    default -> {
                    }
                }
                slugcat.setHunger(slugcat.getHunger() + hungerIncrement);
                System.out.println(slugcat.getHunger());
            }
        }
    }

    /* end of ASB */

    public Map<Integer, Supplier<? extends EntityType<? extends SlugcatEntity>>> scugs =
            Map.of(
                    0, ModEntities.SLUGCAT,
                    1, ModEntities.MONK,
                    2, ModEntities.SURVIVOR,
                    3, ModEntities.HUNTER,
                    4, ModEntities.VOID
            );

    public SlugcatEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
        this.setTame(false, false);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(INTERNALTICKTIMER, 0).define(HUNGER, 20);
    }

    @Override
    protected void registerGoals() {
        this.eatCropGoal = new EatCropGoal(this);
        this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, true));
        this.targetSelector.addGoal(1, this.eatCropGoal);
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Animal.class, true, true) {
            @Override
            public boolean canUse() {
                LivingEntity checkTarget = this.mob.level().getNearestEntity(this.mob.level().getEntitiesOfClass(this.targetType, this.getTargetSearchArea(this.getFollowDistance()), (p_148152_) -> true), this.targetConditions, this.mob, this.mob.getX(), this.mob.getEyeY(), this.mob.getZ());
                SlugcatEntity sclug = (SlugcatEntity)this.mob;
                if (checkTarget != null || !(sclug instanceof MonkSlugcatEntity)) {
                    if (sclug.state == SlugcatState.HUNGRY) {
                        if (checkTarget instanceof SlugcatEntity) {
                            return false;
                        }
                    } else if (sclug.state == SlugcatState.STARVING) {
                        if (checkTarget instanceof SlugcatEntity) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
                return super.canUse();
            }
        });
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.0));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this).setAlertOthers());
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.2, Ingredient.of(ModItems.BLUEFRUIT.get()), false));
        this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.25));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, (float) 10));

        this.targetSelector.addGoal(6, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.goalSelector.addGoal(7, new FollowOwnerGoal(this, 1, (float) 10, (float) 2));

        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(2, new FloatGoal(this));
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25, 20, 10f));
    }

    protected void customServerAiStep() {
        this.eatAnimationTick = this.eatCropGoal.getEatAnimationTick();
        super.customServerAiStep();
    }

    public void aiStep() {
        if (this.level().isClientSide) {
            this.eatAnimationTick = Math.max(0, this.eatAnimationTick - 1);
        }

        super.aiStep();
    }

    public void handleEntityEvent(byte id) {
        if (id == 10) {
            this.eatAnimationTick = 40;
        } else {
            super.handleEntityEvent(id);
        }
    }

    public void ate() {
        super.ate();
        this.setHunger(this.getHunger() + 5);
        if (this.isBaby()) {
            this.ageUp(60);
        }
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
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        Item item = itemStack.getItem();
        if (!this.level().isClientSide || this.isBaby() && this.isFood(itemStack)) {
            if (this.isTame()) {
                boolean consumed = false;
                if (this.isFood(itemStack) && this.getHunger() < this.getMaxHunger()) {
                    if (!consumed) {
                        itemStack.consume(1, player);
                        consumed = true;
                    }
                    this.setHunger(this.getHunger() + 1);
                }
                if (this.isFood(itemStack) && this.getHealth() < this.getMaxHealth()) {
                    if (!consumed) {
                        itemStack.consume(1, player);
                        consumed = true;
                    }
                    FoodProperties foodProperties = (FoodProperties)itemStack.get(DataComponents.FOOD);
                    float f = foodProperties != null ? foodProperties.nutrition() : 1.0F;
                    this.heal(2.0F * f);
                    return InteractionResult.sidedSuccess(this.level().isClientSide());
                }
            } else if (this.isFood(itemStack)) {
                itemStack.consume(1, player);
                this.tryToTame(player);
                return InteractionResult.SUCCESS;
            }
            return super.mobInteract(player, hand);
        } else {
            boolean bl = this.isOwnedBy(player) || this.isTame() || this.isFood(itemStack) && !this.isTame();
            return bl ? InteractionResult.CONSUME : InteractionResult.PASS;
        }
    }

    private void tryToTame(Player player) {
        if (this.random.nextInt(3) == 0) {
            this.tame(player);
            this.navigation.stop();
            this.setTarget(null);
            this.setOrderedToSit(true);
            this.level().broadcastEntityEvent(this, (byte)7);
        } else {
            this.level().broadcastEntityEvent(this, (byte)6);
        }
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(ModTags.Items.SLUG_FOOD);
    }

    @Override
    public boolean canBeLeashed() {
        return true;
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        int weightedRandom = Mth.nextInt(RandomSource.create(), 0, 101);
        int scug = 0;
        if (80 <= weightedRandom && weightedRandom <= 101) {
            scug = Mth.nextInt(RandomSource.create(), 1, 5);
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
        if(this.isInSittingPose()) {
            this.sitAnimationState.start(this.tickCount);

        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("InternalTickTimer", this.getInternalTickTimer());
        compound.putInt("Hunger", this.getHunger());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setInternalTickTimer(compound.getInt("InternalTickTimer"));
        this.setHunger(compound.getInt("Hunger"));
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getInternalTickTimer() >= 600) {
            if (this.getHunger() == 0) {
                this.hurt(new DamageSource(level().holderOrThrow(DamageTypes.STARVE)), 1);
            } else if (this.getHunger() > 0) {
                this.decrementHunger();
            }
            this.setInternalTickTimer(0);
        }

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        } else {
            this.incrementInternalTickTimer();
            if (this.getHunger() < this.getMaxHunger() && this.state == SlugcatState.NORMAL) {
                this.state = SlugcatState.HUNGRY;
            } else if (this.getHunger() <= 0) {
                this.state = SlugcatState.STARVING;
            }
        }
    }

    @Override
    public @NotNull SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @javax.annotation.Nullable SpawnGroupData spawnGroupData) {
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
