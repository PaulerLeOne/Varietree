package com.paulerleone.varietree.grower;

import com.paulerleone.varietree.registry.ConfiguredFeatureRegistry;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class SpruceNewTreeGrower extends AbstractMegaTreeGrower{

	@Override
	protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random,
			boolean hasFlower) {
		switch(random.nextInt(4)) {
		case 0: return TreeFeatures.PINE;
		case 1: return ConfiguredFeatureRegistry.XMAS_SPRUCE.getHolder().get();
		case 2: return ConfiguredFeatureRegistry.CANDLE_SPRUCE.getHolder().get();
		default: return TreeFeatures.SPRUCE;
		}
	}

	@Override
	protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredMegaFeature(RandomSource random) {
	      return random.nextBoolean() ? TreeFeatures.MEGA_SPRUCE : TreeFeatures.MEGA_PINE;
	   }

}
