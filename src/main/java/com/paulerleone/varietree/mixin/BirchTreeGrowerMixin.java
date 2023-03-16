package com.paulerleone.varietree.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.paulerleone.varietree.registry.ConfiguredFeatureRegistry;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.BirchTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

@Mixin(BirchTreeGrower.class)
public class BirchTreeGrowerMixin {
	
	@Inject(method="getConfiguredFeature", at= @At("HEAD"), cancellable = true)
	protected void getConfiguredFeature(RandomSource random, boolean hasBees, CallbackInfoReturnable<Holder<? extends ConfiguredFeature<?,?>>> cir) {
		if(hasBees && random.nextInt(10)==0){
			cir.setReturnValue(TreeFeatures.SUPER_BIRCH_BEES_0002);
		} else {
			switch(random.nextInt(4)) {
			case 0: cir.setReturnValue(ConfiguredFeatureRegistry.ROD_BIRCH.getHolder().get()); break;
			case 1: cir.setReturnValue(ConfiguredFeatureRegistry.LOLLIPOP_BIRCH.getHolder().get()); break;
			case 2: cir.setReturnValue(ConfiguredFeatureRegistry.BIG_BIRCH.getHolder().get()); break;
			default: cir.setReturnValue(hasBees? TreeFeatures.BIRCH_BEES_005 : TreeFeatures.BIRCH); break;
			}
		}
	}

}
