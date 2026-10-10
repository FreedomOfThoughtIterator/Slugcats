Slup entity
The Slup entity should not move on its own. It will have 3 distinct behaviours.
    -Sleeping
    -Writhing
    -Hungry

Sleeping
    -Self-explinitory, when sleeping the Slup will remain still and produce snoring noises.
    -Slugcats will not be able to pick up the Slup.

Writhing
    -The slug will writhe on the ground, still not moving.
    -It will cry out, if a Slugcat happens to walk near it, the Slugcat will pick up the Slup, placing it on its head
    -Slups will not writhe when on soft material (Wool)
    -A Slugcat carrying a Slup will attempt to pathfind to an indoor soft material, at which point the Slugcat will place down the Slup.

Hungry
    -Similar to writhing, the Slup will crave food.
    -If the Slup is not fed, it will die after 12000 ticks
    -Any Slugcat near a hungry Slup will attempt to feed the Slup

Advanced Slugcat Behaviours
    -Hunger

Hunger
    -A Slugcat will have an internal Hungar bar.
    -When this hungar bar is empty, the Slugcat will enter the "Hungry" state.
    -If a Slugcat does not eat within 12000 ticks, the Slugcat will become starving.
    -When a Slugcat is starving, it become weaker
    -After 6000 ticks of starving, the Slugcat will die.
