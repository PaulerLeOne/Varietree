package com.paulerleone.varietree.grower;

import com.paulerleone.varietree.registry.ConfiguredFeatureRegistry;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class BirchNewTreeGrower extends AbstractTreeGrower{

	@Override
	protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random,
			boolean hasFlower) {
		if(hasFlower && random.nextInt(10)==0){
			return TreeFeatures.SUPER_BIRCH_BEES_0002;
		} else {
			switch(random.nextInt(4)) {
			case 0: return ConfiguredFeatureRegistry.ROD_BIRCH.getHolder().get();
			case 1: return ConfiguredFeatureRegistry.LOLLIPOP_BIRCH.getHolder().get();
			case 2: return ConfiguredFeatureRegistry.BIG_BIRCH.getHolder().get();
			default: return hasFlower? TreeFeatures.BIRCH_BEES_005 : TreeFeatures.BIRCH;
			}
		}
	}

}
