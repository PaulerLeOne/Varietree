package com.paulerleone.varietree.foliageplacer.oak;

import java.util.function.BiConsumer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.paulerleone.varietree.registry.FoliagePlacerTypeRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class SandwichOakFoliagePlacer extends FoliagePlacer{
	
	public static final Codec<SandwichOakFoliagePlacer> CODEC = RecordCodecBuilder.create( (placer) -> foliagePlacerParts(placer).apply(placer, SandwichOakFoliagePlacer::new));

	public SandwichOakFoliagePlacer(IntProvider int_one, IntProvider int_two) {
		super(int_one, int_two);
	}

	@Override
	protected FoliagePlacerType<?> type() {
		return FoliagePlacerTypeRegistry.SANDWICH_OAK_PLACER.get();
	}
	
	@Override
		public int foliageHeight(RandomSource p_225601_, int p_225602_, TreeConfiguration p_225603_) {
			return 0;
		}
	
	@Override
	protected void createFoliage(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> blockSetter,
			RandomSource random, TreeConfiguration config, int maxFreeTreeHeight, FoliageAttachment attachment,
			int height, int length, int offset) {
		
		this.placeLeavesRow(level, blockSetter, random, config, attachment.pos(), 1, 1, attachment.doubleTrunk());
		this.placeLeavesRow(level, blockSetter, random, config, attachment.pos(), 2, 0, attachment.doubleTrunk());
		this.placeLeavesRow(level, blockSetter, random, config, attachment.pos(), 3, -1, attachment.doubleTrunk());
		this.placeLeavesRow(level, blockSetter, random, config, attachment.pos(), 2, -2, attachment.doubleTrunk());
		this.placeLeavesRow(level, blockSetter, random, config, attachment.pos(), 3, -3, attachment.doubleTrunk());
		this.placeLeavesRow(level, blockSetter, random, config, attachment.pos(), 1, -4, attachment.doubleTrunk());
		
	}

	@Override
	protected boolean shouldSkipLocation(RandomSource random, int xOffset, int yOffset, int zOffset,
			int radius, boolean isDoubleTrunk) {
		return ( xOffset == radius && zOffset == radius && yOffset == 1) || 
				((xOffset + zOffset)>2 && yOffset == 0) ||
				((xOffset + zOffset)>4 && yOffset == -1) || 
				( xOffset == radius && zOffset == radius && yOffset == -2) ||
				((xOffset + zOffset)>4 && yOffset == -3);
	}

}
