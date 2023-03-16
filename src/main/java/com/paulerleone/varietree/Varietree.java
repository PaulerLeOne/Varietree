package com.paulerleone.varietree;

import com.paulerleone.varietree.registry.ConfiguredFeatureRegistry;
import com.paulerleone.varietree.registry.FeatureRegistry;
import com.paulerleone.varietree.registry.FoliagePlacerTypeRegistry;
import com.paulerleone.varietree.registry.PlacedFeatureRegistry;
import com.paulerleone.varietree.registry.TrunkPlacerTypeRegistry;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Varietree.MODID)
public class Varietree {
	public static final String MODID = "varietree";
	
	public Varietree() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		FoliagePlacerTypeRegistry.FOLIAGE_PLACER_TYPES.register(bus);
		FeatureRegistry.FEATURES.register(bus);
		ConfiguredFeatureRegistry.CONFIGURED_FEATURES.register(bus);
		PlacedFeatureRegistry.PLACEMENTS.register(bus);
		TrunkPlacerTypeRegistry.TRUNK_PLACER_TYPES.register(bus);
		
		MinecraftForge.EVENT_BUS.register(this);

		
		/*
		 * TO DO:
		 * Change MegaOak to redesign, make it have different orientations
		 * Add no beehive variants
		 * Incorporate no beehive variants
		 */
	}
}