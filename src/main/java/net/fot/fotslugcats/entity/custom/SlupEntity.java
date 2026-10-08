package net.fot.fotslugcats.entity.custom;

import net.fot.fotslugcats.entity.ModEntities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.level.Level;

public class SlupEntity extends SlugcatEntity {

    public SlupEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new PanicGoal(this, 2));
        this.goalSelector.addGoal(1, new FollowParentGoal(this, 1.5f));

    }

}
