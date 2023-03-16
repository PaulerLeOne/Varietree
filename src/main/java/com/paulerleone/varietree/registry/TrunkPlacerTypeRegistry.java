package com.paulerleone.varietree.registry;

import com.paulerleone.varietree.Varietree;
import com.paulerleone.varietree.trunkplacer.MegaOakTrunkPlacer;

import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class TrunkPlacerTypeRegistry {
	public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER_TYPES = DeferredRegister.create(Registry.TRUNK_PLACER_TYPE_REGISTRY, Varietree.MODID);
	
	public static final RegistryObject<TrunkPlacerType<MegaOakTrunkPlacer>> MEGA_OAK_TRUNK_PLACER = TRUNK_PLACER_TYPES.register(
			"mega_oak_trunk_placer", () -> new TrunkPlacerType<>(MegaOakTrunkPlacer.CODEC));
}
