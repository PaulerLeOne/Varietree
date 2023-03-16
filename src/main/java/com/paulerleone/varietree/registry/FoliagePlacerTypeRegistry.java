package com.paulerleone.varietree.registry;

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

import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FoliagePlacerTypeRegistry {
	
	public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACER_TYPES = DeferredRegister.create(ForgeRegistries.FOLIAGE_PLACER_TYPES, Varietree.MODID);
	
	public static final RegistryObject<FoliagePlacerType<ShortOakFoliagePlacer>> SHORT_OAK_PLACER = FOLIAGE_PLACER_TYPES.register(
			"short_oak_foliage_placer", () -> new FoliagePlacerType<>(ShortOakFoliagePlacer.CODEC));
	
	public static final RegistryObject<FoliagePlacerType<LollipopOakFoliagePlacer>> LOLLIPOP_OAK_PLACER = FOLIAGE_PLACER_TYPES.register(
			"lollipop_oak_foliage_placer", () -> new FoliagePlacerType<>(LollipopOakFoliagePlacer.CODEC));
	
	public static final RegistryObject<FoliagePlacerType<SandwichOakFoliagePlacer>> SANDWICH_OAK_PLACER = FOLIAGE_PLACER_TYPES.register(
			"sandwich_oak_foliage_placer", () -> new FoliagePlacerType<>(SandwichOakFoliagePlacer.CODEC));
	
	public static final RegistryObject<FoliagePlacerType<MegaOakFoliagePlacer>> MEGA_OAK_PLACER = FOLIAGE_PLACER_TYPES.register(
			"mega_oak_foliage_placer", () -> new FoliagePlacerType<>(MegaOakFoliagePlacer.CODEC));
	
	public static final RegistryObject<FoliagePlacerType<LollipopBirchFoliagePlacer>> LOLLIPOP_BIRCH_PLACER = FOLIAGE_PLACER_TYPES.register(
			"lollipop_birch_foliage_placer", () -> new FoliagePlacerType<>(LollipopBirchFoliagePlacer.CODEC));
	
	public static final RegistryObject<FoliagePlacerType<RodBirchFoliagePlacer>> ROD_BIRCH_PLACER = FOLIAGE_PLACER_TYPES.register(
			"rod_birch_foliage_placer", () -> new FoliagePlacerType<>(RodBirchFoliagePlacer.CODEC));
	
	public static final RegistryObject<FoliagePlacerType<BigBirchFoliagePlacer>> BIG_BIRCH_PLACER = FOLIAGE_PLACER_TYPES.register(
			"big_birch_foliage_placer", () -> new FoliagePlacerType<>(BigBirchFoliagePlacer.CODEC));
	
	public static final RegistryObject<FoliagePlacerType<CandleSpruceFoliagePlacer>> CANDLE_SPRUCE_PLACER = FOLIAGE_PLACER_TYPES.register(
			"candle_spruce_foliage_placer", () -> new FoliagePlacerType<>(CandleSpruceFoliagePlacer.CODEC));
	
	public static final RegistryObject<FoliagePlacerType<XmasSpruceFoliagePlacer>> XMAS_SPRUCE_PLACER = FOLIAGE_PLACER_TYPES.register(
			"xmas_spruce_foliage_placer", () -> new FoliagePlacerType<>(XmasSpruceFoliagePlacer.CODEC));
	
	
	
	
}
