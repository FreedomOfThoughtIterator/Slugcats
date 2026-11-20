package net.fot.fotslugcats.entity.custom;

import net.fot.fotslugcats.entity.SlugcatState;
import net.fot.fotslugcats.sound.ModSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class VoidSlugcatEntity extends HunterSlugcatEntity {
    public VoidSlugcatEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected PathNavigation createNavigation(Level level) {
        return new WallClimberNavigation(this, level);
    }


    public static AttributeSupplier.Builder createAttributes() {
        return TamableAnimal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20d)
                .add(Attributes.MOVEMENT_SPEED, 0.3d)
                .add(Attributes.FOLLOW_RANGE, 64d)
                .add(Attributes.ATTACK_DAMAGE, 12d)
                .add(Attributes.STEP_HEIGHT, 0.6f)
                ;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal(this, Animal.class, true, true) {
            @Override
            public boolean canUse() {
                LivingEntity checkTarget = this.mob.level().getNearestEntity(this.mob.level().getEntitiesOfClass(this.targetType, this.getTargetSearchArea(this.getFollowDistance()), (p_148152_) -> true), this.targetConditions, this.mob, this.mob.getX(), this.mob.getEyeY(), this.mob.getZ());
                SlugcatEntity sclug = (SlugcatEntity)this.mob;
                if (checkTarget != null) {
                    if (sclug.state == SlugcatState.HUNGRY) {
                        if (checkTarget instanceof VoidSlugcatEntity) {
                            return false;
                        }
                    } else if (sclug.state == SlugcatState.STARVING) {
                        if (checkTarget instanceof VoidSlugcatEntity) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
                return super.canUse();
            }
        });
    }

    @Override
    public void tick() {
        super.tick();
        this.setClimbing(this.horizontalCollision);
    }

    public boolean onClimbable() {
        return this.isClimbing();
    }

    public boolean isClimbing() {
        return ((Byte)this.entityData.get(DATA_FLAGS_ID) & 1) != 0;
    }

    public void setClimbing(boolean climbing) {
        byte b0 = (Byte)this.entityData.get(DATA_FLAGS_ID);
        if (climbing) {
            b0 = (byte)(b0 | 1);
        } else {
            b0 = (byte)(b0 & -2);
        }

        this.entityData.set(DATA_FLAGS_ID, b0);
    }

    /* SOUNDS */

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return ModSounds.voidmeow.get();
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource damageSource) {
        return ModSounds.slugcathit.get();
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return ModSounds.slugcathit.get();
    }

}
