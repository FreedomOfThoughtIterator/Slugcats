package net.fot.fotslugcats.entity.goals;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.EatBlockGoal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import net.neoforged.neoforge.event.EventHooks;

import java.util.function.Predicate;

public class EatCropGoal extends EatBlockGoal {
    private final Mob mob;
    private final Level level;
    private int eatAnimationTick = 40;

    public EatCropGoal(Mob mob) {
        super(mob);
        this.mob = mob;
        this.level = mob.level();
    }

    @Override
    public boolean canUse() {
        BlockPos blockpos = this.mob.blockPosition();
        return this.level.getBlockState(blockpos).is(BlockTags.CROPS);
    }

    public void start() {
        this.eatAnimationTick = this.adjustedTickDelay(40);
        this.level.broadcastEntityEvent(this.mob, (byte)10);
        this.mob.getNavigation().stop();
    }

    public void stop() {
        this.eatAnimationTick = 0;
    }

    public boolean canContinueToUse() {
        return this.eatAnimationTick > 0;
    }

    public int getEatAnimationTick() {
        return this.eatAnimationTick;
    }

    @Override
    public void tick() {
        this.eatAnimationTick = Math.max(0, this.eatAnimationTick - 1);
        if (this.eatAnimationTick == this.adjustedTickDelay(4)) {
            BlockPos blockpos = this.mob.blockPosition().above();
            System.out.println(this.level.getBlockState(blockpos));
            if (this.level.getBlockState(blockpos).is(BlockTags.CROPS)) {
                if (EventHooks.canEntityGrief(this.level, this.mob)) {
                    this.level.destroyBlock(blockpos, false);
                }
                this.mob.ate();
            }
        }

    }
}
