package com.paulerleone.varietree.grower;

import com.paulerleone.varietree.registry.ConfiguredFeatureRegistry;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class OakNewTreeGrower extends AbstractMegaTreeGrower{
	
	@Override
	protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredMegaFeature(RandomSource random) {
		return ConfiguredFeatureRegistry.MEGA_OAK.getHolder().get();
	}

	@Override
	protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random,
			boolean hasFlower) {
		if (random.nextInt(10) == 0) {
			return hasFlower ? TreeFeatures.FANCY_OAK_BEES_005 : TreeFeatures.FANCY_OAK;
		} else {
			switch(random.nextInt(4)) {
			case 0: return hasFlower ? ConfiguredFeatureRegistry.LOLLIPOP_OAK_005.getHolder().get() : ConfiguredFeatureRegistry.LOLLIPOP_OAK.getHolder().get(); 
			case 1: return hasFlower ? ConfiguredFeatureRegistry.SHORT_OAK_005.getHolder().get() : ConfiguredFeatureRegistry.SHORT_OAK.getHolder().get(); 
			case 2: return hasFlower ? ConfiguredFeatureRegistry.SANDWICH_OAK_005.getHolder().get() : ConfiguredFeatureRegistry.SANDWICH_OAK.getHolder().get(); 
			default: return hasFlower ? TreeFeatures.OAK_BEES_005 : TreeFeatures.OAK;
			}
		}
	}

}
