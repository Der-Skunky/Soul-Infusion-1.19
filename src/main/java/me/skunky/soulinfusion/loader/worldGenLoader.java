package me.skunky.soulinfusion.loader;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.Arrays;
import java.util.function.Predicate;

public class worldGenLoader {

    public static void init() {
        register("crystal_ore", CRYSTAL_ORE, CRYSTAL_ORE_PLACED, BiomeSelectors.foundInOverworld());
        register("crystal_ore_deepslate", CRYSTAL_ORE_DEEPSLATE, CRYSTAL_ORE_DEEPSLATE_PLACED, BiomeSelectors.foundInOverworld());
        register("crystal_ore_nether", CRYSTAL_ORE_NETHER, CRYSTAL_ORE_NETHER_PLACED, BiomeSelectors.foundInTheNether());
    }

    // configured Features
    public static ConfiguredFeature<?, ?> CRYSTAL_ORE= new ConfiguredFeature(Feature.ORE,
            new OreFeatureConfig(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, blockLoader.CRYSTAL_ORE.getDefaultState(), 3)); // vein Size

    public static ConfiguredFeature<?, ?> CRYSTAL_ORE_DEEPSLATE = new ConfiguredFeature(Feature.ORE,
            new OreFeatureConfig(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, blockLoader.CRYSTAL_ORE_DEEPSLATE.getDefaultState(), 5)); // vein Size

    public static ConfiguredFeature<?, ?> CRYSTAL_ORE_NETHER = new ConfiguredFeature(Feature.ORE,
            new OreFeatureConfig(OreConfiguredFeatures.NETHERRACK, blockLoader.CRYSTAL_ORE_NETHERRACK.getDefaultState(), 7)); // vein Size



    // placed Features
    public static PlacedFeature CRYSTAL_ORE_PLACED = new PlacedFeature(
            RegistryEntry.of(CRYSTAL_ORE),
            Arrays.asList(
                    CountPlacementModifier.of(4), // veins per chunk
                    SquarePlacementModifier.of(), // spreading horizontally
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(72)) // height
            )
    );

    public static PlacedFeature CRYSTAL_ORE_DEEPSLATE_PLACED = new PlacedFeature(
            RegistryEntry.of(CRYSTAL_ORE_DEEPSLATE),
            Arrays.asList(
                    CountPlacementModifier.of(6), // veins per Chunk
                    SquarePlacementModifier.of(), // spreading horizontally
                    HeightRangePlacementModifier.uniform(YOffset.fixed(-62), YOffset.fixed(0))
            )
    );

    public static PlacedFeature CRYSTAL_ORE_NETHER_PLACED = new PlacedFeature(
            RegistryEntry.of(CRYSTAL_ORE_NETHER),
            Arrays.asList(
                    CountPlacementModifier.of(9), // veins per chunk
                    SquarePlacementModifier.of(), //spreading horizontally
                    PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE
            )
    );


    /**
     * @param name = name of the configuredFeature and placedFeature
     * @param configuredFeature = set where the ore is generated and the size of that vein
     * @param placedFeature = set how many veins are generated per chunk and the range of that
     * @param selectors = Where should the Ore be generated overworld/nether/end
     */
    public static void register(String name, ConfiguredFeature configuredFeature, PlacedFeature placedFeature, Predicate<BiomeSelectionContext> selectors) {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Soulinfusion.MOD_ID, name), configuredFeature);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(Soulinfusion.MOD_ID, name), placedFeature);
        BiomeModifications.addFeature(selectors, GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                        new Identifier(Soulinfusion.MOD_ID, name)));
    }
}
