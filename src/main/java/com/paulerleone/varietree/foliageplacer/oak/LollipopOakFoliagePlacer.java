package com.paulerleone.varietree.foliageplacer.oak;

import java.util.function.BiConsumer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.paulerleone.varietree.foliageplacer.ModFoliagePlacer;
import com.paulerleone.varietree.registry.FoliagePlacerTypeRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class LollipopOakFoliagePlacer extends ModFoliagePlacer {

	public LollipopOakFoliagePlacer(IntProvider int_one, IntProvider int_two) {
		super(int_one, int_two);
	}
	
	public static final Codec<LollipopOakFoliagePlacer> CODEC = RecordCodecBuilder.create( (placer) -> foliagePlacerParts(placer).apply(placer, LollipopOakFoliagePlacer::new));

	@Override
	protected FoliagePlacerType<?> type() {	
		return FoliagePlacerTypeRegistry.LOLLIPOP_OAK_PLACER.get();
	}

	@Override
	protected void createFoliage(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> blockSetter,
			RandomSource random, TreeConfiguration config, int maxFreeTreeHeight, FoliageAttachment attachment,
			int height, int length, int offset) {
		
		this.placeLeavesRow(level, blockSetter, random, config, attachment.pos(), 1, 0, attachment.doubleTrunk());
		this.placeLeavesRow(level, blockSetter, random, config, attachment.pos(), 2, -1, attachment.doubleTrunk());
		this.placeLeavesRow(level, blockSetter, random, config, attachment.pos(), 2, -2, attachment.doubleTrunk());
		this.placeLeavesRow(level, blockSetter, random, config, attachment.pos(), 2, -3, attachment.doubleTrunk());

	}

	@Override
	public int foliageHeight(RandomSource p_225601_, int p_225602_, TreeConfiguration p_225603_) {
		return 0;
	}

	@Override
	protected boolean shouldSkipLocation(RandomSource random, int xOffset, int yOffset, int zOffset,
			int radius, boolean isDoubleTrunk) {
		return (xOffset == radius && zOffset == radius && yOffset == 0) || (xOffset == radius && zOffset == radius && yOffset == -1) 
				|| ((xOffset + zOffset)>2 && yOffset == -3);
	}

}
