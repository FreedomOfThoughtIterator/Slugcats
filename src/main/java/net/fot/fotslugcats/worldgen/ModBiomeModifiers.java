package net.fot.fotslugcats.worldgen;

import net.fot.fotslugcats.FoTSlugcats;
import net.fot.fotslugcats.entity.ModEntities;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.List;

public class ModBiomeModifiers {


    public static final ResourceKey<BiomeModifier> SPAWN_SLUGCAT = registerKey("spawn_slugcat");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);


        context.register(SPAWN_SLUGCAT, new BiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.PLAINS), biomes.getOrThrow(Biomes.RIVER), biomes.getOrThrow(Biomes.BIRCH_FOREST), biomes.getOrThrow(Biomes.DARK_FOREST), biomes.getOrThrow(Biomes.CHERRY_GROVE)),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.SLUGCAT.get(), 20, 5, 10)))
        );
    }

    public static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID, name));
    }
}
