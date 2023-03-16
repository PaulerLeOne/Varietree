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

public class ShortOakFoliagePlacer extends ModFoliagePlacer{
	
	private boolean orientation;
	
	public static final Codec<ShortOakFoliagePlacer> CODEC = RecordCodecBuilder.create( (placer) -> foliagePlacerParts(placer).apply(placer, ShortOakFoliagePlacer::new));

	public ShortOakFoliagePlacer(IntProvider int_one, IntProvider int_two) {
		super(int_one, int_two);
	}

	@Override
	protected FoliagePlacerType<?> type() {
		return FoliagePlacerTypeRegistry.SHORT_OAK_PLACER.get();
	}
	
	@Override
		public int foliageHeight(RandomSource p_225601_, int p_225602_, TreeConfiguration p_225603_) {
			return 0;
		}
	
	@Override
	protected void createFoliage(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> blockSetter,
			RandomSource random, TreeConfiguration config, int maxFreeTreeHeight, FoliageAttachment attachment,
			int height, int length, int offset) {
		
		this.orientation = random.nextBoolean();
		
		this.placeLeavesRow(level, blockSetter, random, config, attachment.pos(), 1, 0, attachment.doubleTrunk());
		this.placeLeavesRow(level, blockSetter, random, config, attachment.pos(), 2, -1, attachment.doubleTrunk());
		this.placeLeavesRow(level, blockSetter, random, config, attachment.pos(), 2, -2, attachment.doubleTrunk());
		this.placeLeavesRow(level, blockSetter, random, config, attachment.pos(), 2, -3, attachment.doubleTrunk());
		
	}
	
	@Override
	protected boolean shouldSkipLocationSigned(RandomSource random, int xOffset, int yOffset, int zOffset, int radius,
			boolean isDoubleTrunk){
		return shouldSkipLocation(random, xOffset, yOffset, zOffset, radius, isDoubleTrunk);
	}

	@Override
	protected boolean shouldSkipLocation(RandomSource random, int xOffset, int yOffset, int zOffset,
			int radius, boolean isDoubleTrunk) {
		if (orientation) {
			return (Math.abs(xOffset) == radius && Math.abs(zOffset) == radius && yOffset == 0) || ((Math.abs(xOffset - zOffset)>2 || Math.abs(xOffset + zOffset)>3) && yOffset == -1) 
					|| ((Math.abs(xOffset + zOffset)>2 || Math.abs(xOffset - zOffset)>3) && yOffset == -3);
		} else {
		return (Math.abs(xOffset) == radius && Math.abs(zOffset) == radius && yOffset == 0) || ((Math.abs(xOffset + zOffset)>2 || Math.abs(xOffset - zOffset)>3) && yOffset == -1) 
				|| ((Math.abs(xOffset - zOffset)>2 || Math.abs(xOffset + zOffset)>3) && yOffset == -3);
		}
	}

}
