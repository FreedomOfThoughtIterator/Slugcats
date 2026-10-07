package net.fot.fotslugcats.entity.custom;

import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;

public class SurvivorSlugcatEntity extends SlugcatEntity {
    public SurvivorSlugcatEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }
}
