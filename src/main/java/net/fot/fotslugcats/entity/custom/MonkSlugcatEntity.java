package net.fot.fotslugcats.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;

public class MonkSlugcatEntity extends SlugcatEntity {
    public MonkSlugcatEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }
}
