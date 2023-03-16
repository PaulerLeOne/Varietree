package com.paulerleone.varietree.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.paulerleone.varietree.registry.ConfiguredFeatureRegistry;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.SpruceTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

@Mixin(SpruceTreeGrower.class)
public class SpruceTreeGrowerMixin {
	
	@Inject(method="getConfiguredFeature", at= @At("HEAD"), cancellable = true)
	protected void getConfiguredFeature(RandomSource random, boolean hasBees, CallbackInfoReturnable<Holder<? extends ConfiguredFeature<?,?>>> cir) {
		switch(random.nextInt(4)) {
		case 0: cir.setReturnValue(TreeFeatures.PINE); break;
		case 1: cir.setReturnValue(ConfiguredFeatureRegistry.XMAS_SPRUCE.getHolder().get()); break;
		case 2: cir.setReturnValue(ConfiguredFeatureRegistry.CANDLE_SPRUCE.getHolder().get()); break;
		default: cir.setReturnValue(TreeFeatures.SPRUCE); break;
		}
	}

}
