package net.fot.fotslugcats.entity.custom;

import net.fot.fotslugcats.entity.ModEntities;
import net.fot.fotslugcats.entity.SlugcatVariant;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class RandomSlugcatEntity extends SlugcatEntity{
    private static final EntityDataAccessor<Integer> VARIANT =
            SynchedEntityData.defineId(RandomSlugcatEntity.class, EntityDataSerializers.INT);

    public RandomSlugcatEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        int scugNum = Mth.nextInt(RandomSource.create(), 0, 3);
        if (scugNum == 0) {
            RandomSlugcatEntity baby = ModEntities.SLUGCAT.get().create(serverLevel);
            if ((serverLevel.getGameTime() & 1) == 0) {
                baby.setVariant(this.getVariant());
            } else {
                if (ageableMob instanceof RandomSlugcatEntity scug) {
                    baby.setVariant(scug.getVariant());
                }
            }
            return baby;
        } else {
            Supplier<? extends EntityType<? extends SlugcatEntity>> slugSpawn = scugs.get(scugNum);
            return slugSpawn.get().create(serverLevel);
        }
    }

    /* VARIANT */

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(VARIANT, 0);
    }

    private int getTypeVariant() {
        return this.entityData.get(VARIANT);
    }

    public SlugcatVariant getVariant() {
        return SlugcatVariant.byId(this.getTypeVariant() & 255);
    }

    private void setVariant(SlugcatVariant variant) {
        this.entityData.set(VARIANT, variant.getId() & 255);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Variant", this.getTypeVariant());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.entityData.set(VARIANT, compound.getInt("Variant"));
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {
        SlugcatVariant variant = Util.getRandom(SlugcatVariant.values(), this.random);
        this.setVariant(variant);
        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    }
}
