package com.paulerleone.varietree.registry;

import java.util.List;

import com.paulerleone.varietree.Varietree;
import com.paulerleone.varietree.foliageplacer.birch.BigBirchFoliagePlacer;
import com.paulerleone.varietree.foliageplacer.birch.LollipopBirchFoliagePlacer;
import com.paulerleone.varietree.foliageplacer.birch.RodBirchFoliagePlacer;
import com.paulerleone.varietree.foliageplacer.oak.LollipopOakFoliagePlacer;
import com.paulerleone.varietree.foliageplacer.oak.MegaOakFoliagePlacer;
import com.paulerleone.varietree.foliageplacer.oak.SandwichOakFoliagePlacer;
import com.paulerleone.varietree.foliageplacer.oak.ShortOakFoliagePlacer;
import com.paulerleone.varietree.foliageplacer.spruce.CandleSpruceFoliagePlacer;
import com.paulerleone.varietree.foliageplacer.spruce.XmasSpruceFoliagePlacer;
import com.paulerleone.varietree.trunkplacer.MegaOakTrunkPlacer;

import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ConfiguredFeatureRegistry {

	public static final DeferredRegister<ConfiguredFeature<?,?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Varietree.MODID);
	
	private static final BeehiveDecorator BEEHIVE_0002 = new BeehiveDecorator(0.002F);
	private static final BeehiveDecorator BEEHIVE_002 = new BeehiveDecorator(0.02F);
	private static final BeehiveDecorator BEEHIVE_005 = new BeehiveDecorator(0.05F);
	private static final BeehiveDecorator BEEHIVE_02 = new BeehiveDecorator(0.2F); 
	
	//TreeConfiguration
	
	public static final RegistryObject<ConfiguredFeature<?,?>> SHORT_OAK = CONFIGURED_FEATURES.register("short_oak",()-> new ConfiguredFeature<>(Feature.TREE, 
			ShortOak().build()));
	public static final RegistryObject<ConfiguredFeature<?,?>> SHORT_OAK_0002 = CONFIGURED_FEATURES.register("short_oak_0002",()-> new ConfiguredFeature<>(Feature.TREE, 
			ShortOak().decorators(List.of(BEEHIVE_0002)).build()));
	public static final RegistryObject<ConfiguredFeature<?,?>> SHORT_OAK_002 = CONFIGURED_FEATURES.register("short_oak_002",()-> new ConfiguredFeature<>(Feature.TREE, 
			ShortOak().decorators(List.of(BEEHIVE_002)).build()));
	public static final RegistryObject<ConfiguredFeature<?,?>> SHORT_OAK_005 = CONFIGURED_FEATURES.register("short_oak_005",()-> new ConfiguredFeature<>(Feature.TREE, 
			ShortOak().decorators(List.of(BEEHIVE_005)).build()));
	public static final RegistryObject<ConfiguredFeature<?,?>> LOLLIPOP_OAK = CONFIGURED_FEATURES.register("lollipop_oak",()-> new ConfiguredFeature<>(Feature.TREE, 
			LollipopOak().build()));
	public static final RegistryObject<ConfiguredFeature<?,?>> LOLLIPOP_OAK_0002 = CONFIGURED_FEATURES.register("lollipop_oak_0002",()-> new ConfiguredFeature<>(Feature.TREE, 
			LollipopOak().decorators(List.of(BEEHIVE_0002)).build()));
	public static final RegistryObject<ConfiguredFeature<?,?>> LOLLIPOP_OAK_005 = CONFIGURED_FEATURES.register("lollipop_oak_005",()-> new ConfiguredFeature<>(Feature.TREE, 
			LollipopOak().decorators(List.of(BEEHIVE_005)).build()));
	public static final RegistryObject<ConfiguredFeature<?,?>> SANDWICH_OAK = CONFIGURED_FEATURES.register("sandwich_oak",()-> new ConfiguredFeature<>(Feature.TREE, 
			SandwichOak().build()));
	public static final RegistryObject<ConfiguredFeature<?,?>> SANDWICH_OAK_0002 = CONFIGURED_FEATURES.register("sandwich_oak_0002",()-> new ConfiguredFeature<>(Feature.TREE, 
			SandwichOak().decorators(List.of(BEEHIVE_0002)).build()));
	public static final RegistryObject<ConfiguredFeature<?,?>> SANDWICH_OAK_005 = CONFIGURED_FEATURES.register("sandwich_oak_005",()-> new ConfiguredFeature<>(Feature.TREE, 
			SandwichOak().decorators(List.of(BEEHIVE_005)).build()));
	
	public static final RegistryObject<ConfiguredFeature<?,?>> MEGA_OAK = CONFIGURED_FEATURES.register("mega_oak", ()-> new ConfiguredFeature<>(Feature.TREE,
			new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG),
					new MegaOakTrunkPlacer(11, 2, 0), BlockStateProvider.simple(Blocks.OAK_LEAVES),
					new MegaOakFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)),  new TwoLayersFeatureSize(2, 0, 2)).decorators(List.of(BEEHIVE_02)).build()));
	
	public static final RegistryObject<ConfiguredFeature<?,?>> ROD_BIRCH = CONFIGURED_FEATURES.register("rod_birch",()-> new ConfiguredFeature<>(Feature.TREE, 
			RodBirch().build()));
	public static final RegistryObject<ConfiguredFeature<?,?>> ROD_BIRCH_0002 = CONFIGURED_FEATURES.register("rod_birch_0002",()-> new ConfiguredFeature<>(Feature.TREE, 
			RodBirch().decorators(List.of(BEEHIVE_0002)).build()));
	public static final RegistryObject<ConfiguredFeature<?,?>> ROD_BIRCH_005 = CONFIGURED_FEATURES.register("rod_birch_005",()-> new ConfiguredFeature<>(Feature.TREE, 
			RodBirch().decorators(List.of(BEEHIVE_005)).build()));
	public static final RegistryObject<ConfiguredFeature<?,?>> LOLLIPOP_BIRCH = CONFIGURED_FEATURES.register("lollipop_birch",()-> new ConfiguredFeature<>(Feature.TREE, 
			LollipopBirch().build()));
	public static final RegistryObject<ConfiguredFeature<?,?>> LOLLIPOP_BIRCH_0002 = CONFIGURED_FEATURES.register("lollipop_birch_0002",()-> new ConfiguredFeature<>(Feature.TREE, 
			LollipopBirch().decorators(List.of(BEEHIVE_0002)).build()));
	public static final RegistryObject<ConfiguredFeature<?,?>> LOLLIPOP_BIRCH_002 = CONFIGURED_FEATURES.register("lollipop_birch_002",()-> new ConfiguredFeature<>(Feature.TREE, 
			LollipopBirch().decorators(List.of(BEEHIVE_002)).build()));
	public static final RegistryObject<ConfiguredFeature<?,?>> LOLLIPOP_BIRCH_005 = CONFIGURED_FEATURES.register("lollipop_birch_005",()-> new ConfiguredFeature<>(Feature.TREE, 
			LollipopBirch().decorators(List.of(BEEHIVE_005)).build()));
	public static final RegistryObject<ConfiguredFeature<?,?>> BIG_BIRCH = CONFIGURED_FEATURES.register("big_birch",()-> new ConfiguredFeature<>(Feature.TREE, 
			BigBirch().build()));
	public static final RegistryObject<ConfiguredFeature<?,?>> BIG_BIRCH_0002 = CONFIGURED_FEATURES.register("big_birch_0002",()-> new ConfiguredFeature<>(Feature.TREE, 
			BigBirch().decorators(List.of(BEEHIVE_0002)).build()));
	public static final RegistryObject<ConfiguredFeature<?,?>> BIG_BIRCH_005 = CONFIGURED_FEATURES.register("big_birch_005",()-> new ConfiguredFeature<>(Feature.TREE, 
			BigBirch().decorators(List.of(BEEHIVE_005)).build()));
	
	public static final RegistryObject<ConfiguredFeature<?,?>> XMAS_SPRUCE = CONFIGURED_FEATURES.register("xmas_spruce",()-> new ConfiguredFeature<>(Feature.TREE, 
			new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.SPRUCE_LOG), 
					new StraightTrunkPlacer(7, 0, 0), BlockStateProvider.simple(Blocks.SPRUCE_LEAVES),
					new XmasSpruceFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(2, 0, 2)).build()));
	public static final RegistryObject<ConfiguredFeature<?,?>> CANDLE_SPRUCE = CONFIGURED_FEATURES.register("candle_spruce",()-> new ConfiguredFeature<>(Feature.TREE, 
			new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.SPRUCE_LOG), 
					new StraightTrunkPlacer(4, 2, 0), BlockStateProvider.simple(Blocks.SPRUCE_LEAVES),
					new CandleSpruceFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(2, 0, 2)).build()));
	
	//Methods
	
	public static TreeConfiguration.TreeConfigurationBuilder ShortOak(){
		return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG), new StraightTrunkPlacer(4, 2, 0), BlockStateProvider.simple(Blocks.OAK_LEAVES), new ShortOakFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(2, 0, 2));
	}
	public static TreeConfiguration.TreeConfigurationBuilder LollipopOak(){
		return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG), new StraightTrunkPlacer(7, 1, 0), BlockStateProvider.simple(Blocks.OAK_LEAVES), new LollipopOakFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(2, 0, 2));
	}
	public static TreeConfiguration.TreeConfigurationBuilder SandwichOak(){
		return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG), new StraightTrunkPlacer(5, 2, 0), BlockStateProvider.simple(Blocks.OAK_LEAVES), new SandwichOakFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(2, 0, 2));
	}
	public static TreeConfiguration.TreeConfigurationBuilder RodBirch(){
		return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.BIRCH_LOG), new StraightTrunkPlacer(7, 2, 0), BlockStateProvider.simple(Blocks.BIRCH_LEAVES), new RodBirchFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(2, 0, 2));
	}
	public static TreeConfiguration.TreeConfigurationBuilder LollipopBirch(){
		return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.BIRCH_LOG), new StraightTrunkPlacer(8, 2, 0), BlockStateProvider.simple(Blocks.BIRCH_LEAVES), new LollipopBirchFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(2, 0, 2));
	}
	public static TreeConfiguration.TreeConfigurationBuilder BigBirch(){
		return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.BIRCH_LOG), new StraightTrunkPlacer(7, 2, 0), BlockStateProvider.simple(Blocks.BIRCH_LEAVES), new BigBirchFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(2, 0, 2));
	}
	
	//RandomFeatureConfiguration
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> TREES_BIRCH = CONFIGURED_FEATURES.register("trees_birch", ()-> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, 
			new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PlacedFeatureRegistry.ROD_BIRCH_0002_PLACED.getHolder().get(), 0.5F)), TreePlacements.BIRCH_BEES_0002_PLACED)));
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> BIRCH_TALL = CONFIGURED_FEATURES.register("birch_tall", ()-> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, 
			new RandomFeatureConfiguration( List.of(new WeightedPlacedFeature(PlacedFeatureRegistry.LOLLIPOP_BIRCH_0002_PLACED.getHolder().get(), 0.3F),
					 new WeightedPlacedFeature(PlacedFeatureRegistry.BIG_BIRCH_0002_PLACED.getHolder().get(), 0.1F),
					 new WeightedPlacedFeature(TreePlacements.SUPER_BIRCH_BEES_0002, 0.2F)), TreePlacements.BIRCH_BEES_0002_PLACED)));
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> TREES_BIRCH_AND_OAK = CONFIGURED_FEATURES.register("trees_birch_and_oak", ()-> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, 
			new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PlacedFeatureRegistry.LOLLIPOP_BIRCH_0002_PLACED.getHolder().get(), 0.1F),
					 new WeightedPlacedFeature(TreePlacements.BIRCH_BEES_0002_PLACED, 0.1F),
					 new WeightedPlacedFeature(TreePlacements.FANCY_OAK_BEES_0002, 0.1F),
					 new WeightedPlacedFeature(PlacedFeatureRegistry.SANDWICH_OAK_0002_PLACED.getHolder().get(), 0.1F), 
					 new WeightedPlacedFeature(PlacedFeatureRegistry.LOLLIPOP_OAK_0002_PLACED.getHolder().get(), 0.2F),
					 new WeightedPlacedFeature(PlacedFeatureRegistry.SHORT_OAK_0002_PLACED.getHolder().get(), 0.3F)), TreePlacements.OAK_BEES_0002)));
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> TREES_TAIGA = CONFIGURED_FEATURES.register("trees_taiga", ()-> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, 
			new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(TreePlacements.PINE_CHECKED, 0.33333334F),
					 new WeightedPlacedFeature(PlacedFeatureRegistry.CANDLE_SPRUCE.getHolder().get(), 0.33333334F)), TreePlacements.SPRUCE_CHECKED)));
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> TREES_SNOWY = CONFIGURED_FEATURES.register("trees_snowy", ()-> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, 
			new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PlacedFeatureRegistry.XMAS_SPRUCE.getHolder().get(), 0.4F),
					 new WeightedPlacedFeature(PlacedFeatureRegistry.CANDLE_SPRUCE.getHolder().get(), 0.1F)), TreePlacements.SPRUCE_CHECKED)));
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> TREES_GROVE = CONFIGURED_FEATURES.register("trees_grove", ()-> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, 
			new RandomFeatureConfiguration( List.of(new WeightedPlacedFeature(TreePlacements.PINE_ON_SNOW, 0.25F),
					 new WeightedPlacedFeature(PlacedFeatureRegistry.XMAS_SPRUCE_ON_SNOW.getHolder().get(), 0.25F),
					 new WeightedPlacedFeature(PlacedFeatureRegistry.CANDLE_SPRUCE_ON_SNOW.getHolder().get(), 0.25F)), TreePlacements.SPRUCE_ON_SNOW)));
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> TREES_FLOWER_FOREST = CONFIGURED_FEATURES.register("trees_flower_forest", ()-> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, 
			new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(TreePlacements.BIRCH_BEES_002, 0.1F), 
					new WeightedPlacedFeature(PlacedFeatureRegistry.LOLLIPOP_BIRCH_002_PLACED.getHolder().get(), 0.1F), 
					new WeightedPlacedFeature(PlacedFeatureRegistry.SHORT_OAK_002_PLACED.getHolder().get(), 0.3F), 
					new WeightedPlacedFeature(TreePlacements.FANCY_OAK_BEES_002, 0.1F)), TreePlacements.OAK_BEES_002)));
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> TREES_WINDSWEPT_HILLS = CONFIGURED_FEATURES.register("trees_windswept_hills", ()-> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, 
			new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(TreePlacements.SPRUCE_CHECKED, 0.366F),
					new WeightedPlacedFeature(PlacedFeatureRegistry.CANDLE_SPRUCE.getHolder().get(), 0.3F),
					new WeightedPlacedFeature(PlacedFeatureRegistry.SANDWICH_OAK_PLACED.getHolder().get(), 0.1F),
					new WeightedPlacedFeature(TreePlacements.FANCY_OAK_CHECKED, 0.1F)), TreePlacements.OAK_CHECKED)));
}
