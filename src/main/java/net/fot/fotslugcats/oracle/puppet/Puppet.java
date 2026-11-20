package net.fot.fotslugcats.oracle.puppet;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;

public class Puppet extends Mob {

    public Puppet(EntityType<? extends Mob> entityType, Level level) {
        super(entityType, level);
    }
}
