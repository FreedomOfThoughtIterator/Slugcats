package net.fot.fotslugcats.entity;

import net.fot.fotslugcats.FoTSlugcats;
import net.fot.fotslugcats.entity.custom.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.awt.*;
import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, FoTSlugcats.MOD_ID);

    public static final Supplier<EntityType<RandomSlugcatEntity>> SLUGCAT =
            ENTITY_TYPES.register("slugcat", () -> EntityType.Builder.of(RandomSlugcatEntity::new, MobCategory.CREATURE)
                    .sized(0.5f, 1f).build("slugcat"));

    public static final Supplier<EntityType<SurvivorSlugcatEntity>> SURVIVOR =
            ENTITY_TYPES.register("survivor", () -> EntityType.Builder.of(SurvivorSlugcatEntity::new, MobCategory.CREATURE)
                    .sized(0.5f, 1f).build("survivor"));

    public static final Supplier<EntityType<MonkSlugcatEntity>> MONK =
            ENTITY_TYPES.register("monk", () -> EntityType.Builder.of(MonkSlugcatEntity::new, MobCategory.CREATURE)
                    .sized(0.5f, 1f).build("monk"));

    public static final Supplier<EntityType<HunterSlugcatEntity>> HUNTER =
            ENTITY_TYPES.register("hunter", () -> EntityType.Builder.of(HunterSlugcatEntity::new, MobCategory.CREATURE)
                    .sized(0.5f, 1f).build("hunter"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
