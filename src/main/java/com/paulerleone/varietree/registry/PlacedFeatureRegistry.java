package com.paulerleone.varietree.registry;

import java.util.List;

import com.paulerleone.varietree.Varietree;

import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class PlacedFeatureRegistry {
	
	public static final DeferredRegister<PlacedFeature> PLACEMENTS = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Varietree.MODID);
	
	//Oak
	public static final RegistryObject<PlacedFeature> SHORT_OAK_PLACED = PLACEMENTS.register("short_oak", ()-> new PlacedFeature(ConfiguredFeatureRegistry.SHORT_OAK.getHolder().get(), List.of(PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING))));
	public static final RegistryObject<PlacedFeature> SHORT_OAK_0002_PLACED = PLACEMENTS.register("short_oak_0002", ()-> new PlacedFeature(ConfiguredFeatureRegistry.SHORT_OAK_0002.getHolder().get(), List.of(PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING))));
	public static final RegistryObject<PlacedFeature> SHORT_OAK_002_PLACED = PLACEMENTS.register("short_oak_002", ()-> new PlacedFeature(ConfiguredFeatureRegistry.SHORT_OAK_002.getHolder().get(), List.of(PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING))));
	public static final RegistryObject<PlacedFeature> LOLLIPOP_OAK_PLACED = PLACEMENTS.register("lollipop_oak", ()-> new PlacedFeature(ConfiguredFeatureRegistry.LOLLIPOP_OAK.getHolder().get(), List.of(PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING))));
	public static final RegistryObject<PlacedFeature> LOLLIPOP_OAK_0002_PLACED = PLACEMENTS.register("lollipop_oak_0002", ()-> new PlacedFeature(ConfiguredFeatureRegistry.LOLLIPOP_OAK_0002.getHolder().get(), List.of(PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING))));
	public static final RegistryObject<PlacedFeature> SANDWICH_OAK_PLACED = PLACEMENTS.register("sandwich_oak", ()-> new PlacedFeature(ConfiguredFeatureRegistry.SANDWICH_OAK.getHolder().get(), List.of(PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING))));
	public static final RegistryObject<PlacedFeature> SANDWICH_OAK_0002_PLACED = PLACEMENTS.register("sandwich_oak_0002", ()-> new PlacedFeature(ConfiguredFeatureRegistry.SANDWICH_OAK_0002.getHolder().get(), List.of(PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING))));
	//Birch
	public static final RegistryObject<PlacedFeature> ROD_BIRCH_PLACED = PLACEMENTS.register("rod_birch", ()-> new PlacedFeature(ConfiguredFeatureRegistry.ROD_BIRCH.getHolder().get(), List.of(PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING))));
	public static final RegistryObject<PlacedFeature> ROD_BIRCH_0002_PLACED = PLACEMENTS.register("rod_birch_0002", ()-> new PlacedFeature(ConfiguredFeatureRegistry.ROD_BIRCH_0002.getHolder().get(), List.of(PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING))));
	public static final RegistryObject<PlacedFeature> LOLLIPOP_BIRCH_PLACED = PLACEMENTS.register("lollipop_birch", ()-> new PlacedFeature(ConfiguredFeatureRegistry.LOLLIPOP_BIRCH.getHolder().get(), List.of(PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING))));
	public static final RegistryObject<PlacedFeature> LOLLIPOP_BIRCH_0002_PLACED = PLACEMENTS.register("lollipop_birch_0002", ()-> new PlacedFeature(ConfiguredFeatureRegistry.LOLLIPOP_BIRCH_0002.getHolder().get(), List.of(PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING))));
	public static final RegistryObject<PlacedFeature> LOLLIPOP_BIRCH_002_PLACED = PLACEMENTS.register("lollipop_birch_002", ()-> new PlacedFeature(ConfiguredFeatureRegistry.LOLLIPOP_BIRCH_002.getHolder().get(), List.of(PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING))));
	public static final RegistryObject<PlacedFeature> BIG_BIRCH_PLACED = PLACEMENTS.register("big_birch", ()-> new PlacedFeature(ConfiguredFeatureRegistry.BIG_BIRCH.getHolder().get(), List.of(PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING))));
	public static final RegistryObject<PlacedFeature> BIG_BIRCH_0002_PLACED = PLACEMENTS.register("big_birch_0002", ()-> new PlacedFeature(ConfiguredFeatureRegistry.BIG_BIRCH_0002.getHolder().get(), List.of(PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING))));
	//Spruce
	public static final RegistryObject<PlacedFeature> CANDLE_SPRUCE = PLACEMENTS.register("candle_spruce", ()-> new PlacedFeature(ConfiguredFeatureRegistry.CANDLE_SPRUCE.getHolder().get(), List.of(PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING))));
	public static final RegistryObject<PlacedFeature> XMAS_SPRUCE = PLACEMENTS.register("xmas_spruce", ()-> new PlacedFeature(ConfiguredFeatureRegistry.XMAS_SPRUCE.getHolder().get(), List.of(PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING))));
	public static final RegistryObject<PlacedFeature> CANDLE_SPRUCE_ON_SNOW = PLACEMENTS.register("candle_spruce_on_snow", ()-> new PlacedFeature(ConfiguredFeatureRegistry.CANDLE_SPRUCE.getHolder().get(), TreePlacements.SNOW_TREE_FILTER_DECORATOR));
	public static final RegistryObject<PlacedFeature> XMAS_SPRUCE_ON_SNOW = PLACEMENTS.register("xmas_spruce_on_snow", ()-> new PlacedFeature(ConfiguredFeatureRegistry.XMAS_SPRUCE.getHolder().get(), TreePlacements.SNOW_TREE_FILTER_DECORATOR));
	
	public static final RegistryObject<PlacedFeature> TREES_BIRCH = PLACEMENTS.register("trees_birch", ()->new PlacedFeature(ConfiguredFeatureRegistry.TREES_BIRCH.getHolder().get(), VegetationPlacements.treePlacement(PlacementUtils.countExtra(10, 0.1F, 1))));
	public static final RegistryObject<PlacedFeature> BIRCH_TALL = PLACEMENTS.register("birch_tall", ()->new PlacedFeature(ConfiguredFeatureRegistry.BIRCH_TALL.getHolder().get(), VegetationPlacements.treePlacement(PlacementUtils.countExtra(10, 0.1F, 1))));
	public static final RegistryObject<PlacedFeature> TREES_BIRCH_AND_OAK = PLACEMENTS.register("trees_birch_and_oak", ()->new PlacedFeature(ConfiguredFeatureRegistry.TREES_BIRCH_AND_OAK.getHolder().get(), VegetationPlacements.treePlacement(PlacementUtils.countExtra(10, 0.1F, 1))));
	public static final RegistryObject<PlacedFeature> TREES_TAIGA = PLACEMENTS.register("trees_taiga", ()->new PlacedFeature(ConfiguredFeatureRegistry.TREES_TAIGA.getHolder().get(), VegetationPlacements.treePlacement(PlacementUtils.countExtra(10, 0.1F, 1))));
	public static final RegistryObject<PlacedFeature> TREES_SNOWY = PLACEMENTS.register("trees_snowy", ()->new PlacedFeature(ConfiguredFeatureRegistry.TREES_SNOWY.getHolder().get(), VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.1F, 1))));
	public static final RegistryObject<PlacedFeature> TREES_GROVE = PLACEMENTS.register("trees_grove", ()->new PlacedFeature(ConfiguredFeatureRegistry.TREES_GROVE.getHolder().get(), VegetationPlacements.treePlacement(PlacementUtils.countExtra(10, 0.1F, 1))));
	public static final RegistryObject<PlacedFeature> TREES_FLOWER_FOREST = PLACEMENTS.register("trees_flower_forest", ()->new PlacedFeature(ConfiguredFeatureRegistry.TREES_FLOWER_FOREST.getHolder().get(), VegetationPlacements.treePlacement(PlacementUtils.countExtra(6, 0.1F, 1))));
	public static final RegistryObject<PlacedFeature> TREES_WINDSWEPT_HILLS = PLACEMENTS.register("trees_windswept_hills", ()->new PlacedFeature(ConfiguredFeatureRegistry.TREES_WINDSWEPT_HILLS.getHolder().get(), VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.1F, 1))));
}
