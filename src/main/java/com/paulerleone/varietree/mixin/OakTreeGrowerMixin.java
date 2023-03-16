package com.paulerleone.varietree.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.paulerleone.varietree.registry.ConfiguredFeatureRegistry;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.OakTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

@Mixin(OakTreeGrower.class)
public class OakTreeGrowerMixin {

	@Inject(method="getConfiguredFeature", at= @At("HEAD"), cancellable = true)
	protected void getConfiguredFeature(RandomSource random, boolean hasBees, CallbackInfoReturnable<Holder<? extends ConfiguredFeature<?,?>>> cir){
		if (random.nextInt(10) == 0) {
			cir.setReturnValue(hasBees ? TreeFeatures.FANCY_OAK_BEES_005 : TreeFeatures.FANCY_OAK);
		} else {
			switch(random.nextInt(4)) {
			case 0: cir.setReturnValue(ConfiguredFeatureRegistry.LOLLIPOP_OAK.getHolder().get()); break;
			case 1: cir.setReturnValue(ConfiguredFeatureRegistry.SHORT_OAK.getHolder().get()); break;
			case 2: cir.setReturnValue(ConfiguredFeatureRegistry.SANDWICH_OAK.getHolder().get()); break;
			default: cir.setReturnValue(hasBees ? TreeFeatures.OAK_BEES_005 : TreeFeatures.OAK); break;
			}
		}	
	}
}
