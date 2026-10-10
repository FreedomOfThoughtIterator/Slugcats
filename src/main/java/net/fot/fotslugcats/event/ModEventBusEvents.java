package net.fot.fotslugcats.event;

import net.fot.fotslugcats.FoTSlugcats;
import net.fot.fotslugcats.entity.ModEntities;
import net.fot.fotslugcats.entity.client.*;
import net.fot.fotslugcats.entity.custom.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

@EventBusSubscriber
    public class ModEventBusEvents {

        @SubscribeEvent
        public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(VoidModel.LAYER_LOCATION, VoidModel::createBodyLayer);
            event.registerLayerDefinition(SlugcatModel.LAYER_LOCATION, SlugcatModel::createBodyLayer);
            event.registerLayerDefinition(SlugpupModel.LAYER_LOCATION, SlugpupModel::createBodyLayer);
            event.registerLayerDefinition(HunterModel.LAYER_LOCATION, HunterModel::createBodyLayer);
        }

        @SubscribeEvent
        public static void registerAttributes(EntityAttributeCreationEvent event) {
            event.put(ModEntities.VOID.get(), VoidSlugcatEntity.createAttributes().build());
            event.put(ModEntities.SLUGCAT.get(), RandomSlugcatEntity.createAttributes().build());
            event.put(ModEntities.SLUP.get(), SlupEntity.createAttributes().build());
            event.put(ModEntities.SURVIVOR.get(), SurvivorSlugcatEntity.createAttributes().build());
            event.put(ModEntities.MONK.get(), SurvivorSlugcatEntity.createAttributes().build());
            event.put(ModEntities.HUNTER.get(), SurvivorSlugcatEntity.createAttributes().build());


        }

        @SubscribeEvent
        public static void registerSpawnPlacements(RegisterSpawnPlacementsEvent event) {
            event.register(ModEntities.SLUGCAT.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    TamableAnimal::checkAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        }
    }
