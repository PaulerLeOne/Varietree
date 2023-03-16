package com.paulerleone.varietree.foliageplacer.oak;

import java.util.List;
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

public class MegaOakFoliagePlacer extends ModFoliagePlacer{
	
	/*
	static final int[][] layer0 = {{1,1,2},{2,0,3},{1,-1,1}};
	static final int[][] layer1 = {{2,3,1},{-1,3,1},{3,2,6},{2,1,4},{2,0,3},{4,-1,7},{3,-2,2},{-1,-2,2}};
	static final int[][] layer2 = {{0,3,1},{1,2,2},{1,1,3},{2,0,4},{1,-1,3},{1,-2,2},{1,-3,2}};
	static final int[][] layer3 = {{0,4,1},{1,3,2},{3,2,5},{3,1,7},{2,0,6},{3,-1,5},{3,-2,2}};
	static final int[][] layer4 = {{0,5,1},{1,4,3},{4,3,8},{5,2,8},{5,1,8},{4,0,7},{4,-1,7},{4,-2,7},{3,-3,2},{-1,-3,2}};
	static final int[][] layer5 = {{3,4,2},{-1,4,3},{3,3,3},{-1,3,3},{2,2,5},{3,1,5},{3,0,4},{1,-1,4},{0,-2,4},{-1,-3,3},{-1,-4,2}};
	static final int[][] layer6 = {{1,5,2},{1,4,2},{2,3,3},{3,2,5},{5,1,10},{5,0,10},{2,-1,4},{1,-2,2},{1,-3,2},{1,-4,2}};
	static final int[][] layer7 = {{1,6,2},{2,5,3},{2,4,4},{3,3,5},{5,2,9},{6,1,12},{6,0,12},{4,-1,8},{3,-2,4},{3,-3,4},{2,-4,3},{2,-5,2}};
	static final int[][] layer8 = {{2,6,3},{3,5,5},{3,4,6},{4,3,9},{5,2,11},{6,1,12},{6,0,12},{6,-1,11},{5,-2,9},{3,-3,6},{2,-4,5},{1,-5,3}};
	static final int[][] layer9 = {{0,3,1},{2,2,1},{0,2,2},{3,1,2},{-1,0,2},{2,-1,2},{-1,-1,1},{1,-2,1}};
	*/
	
	static final int[][] layer0 = {{0,0,2},{0,1,2}};
	static final int[][] layer1 = {{0,-2,1},{-1,-1,3},{-1,0,4},{-1,1,4},{0,2,2}};
	static final int[][] layer2 = {{-1,-3,3},{-2,-2,5},{-2,-1,6},{-3,0,7},{-2,1,5},{-3,2,7},{-2,3,5},{-1,4,3}};
	static final int[][] layer3 = {{-1,-2,4},{-3,-1,1},{-1,-1,3},{-4,0,7},{-3,1,8},{-4,2,9},{-3,3,5},{-2,4,1}};
	static final int[][] layer4 = {{-1,-4,2},{-2,-3,3},{2,-3,2},{-3,-2,8},{-3,-1,7},{-3,0,9},{-4,1,10},{-3,2,6},{-2,3,5},{-3,4,5},{-3,5,2},{0,5,2}};
	static final int[][] layer5 = {{-1,-5,2},{-2,-4,5},{-3,-3,8},{-4,-2,9},{-4,-1,10},{-5,0,12},{-5,1,12},{-4,2,10},{-3,3,6},{-2,4,6},{-2,5,5},{0,6,2}};
	static final int[][] layer6 = {{-1,-4,2},{-2,-3,5},{-2,-2,7},{-4,-1,9},{-3,0,9},{-4,1,11},{-4,2,8},{-4,3,9},{-3,4,2},{0,4,5},{0,5,1}};
	static final int[][] layer7 = {{0,-4,2},{-3,-3,5},{-3,-2,6},{-3,-1,7},{-4,0,9},{-4,1,10},{-2,2,5},{-1,3,4},{-1,4,3},{1,5,1}};
	static final int[][] layer8 = {{0,-5,2},{-1,-4,4},{-2,-3,5},{-2,-2,6},{-3,-1,9},{-5,0,12},{-5,1,12},{-4,2,9},{-2,3,6},{-1,4,4},{-1,5,4},{0,6,2}};
	static final int[][] layer9 = {{-1,-5,3},{-2,-4,5},{-2,-3,6},{-3,-2,9},{-4,-1,11},{-5,0,12},{-5,1,12},{-5,2,11},{-4,3,9},{-2,4,6},{-2,5,6},{0,6,3}};
	static final int[][] layer10 = {{1,-2,1},{-1,-1,1},{1,-1,2},{-2,0,2},{2,1,2},{-1,2,2},{2,2,1},{0,3,1}};
	 
	
	static final List<int[][]> layers = List.of(layer0,layer1,layer2,layer3,layer4,layer5,layer6,layer7,layer8,layer9, layer10);

	public MegaOakFoliagePlacer(IntProvider int_one, IntProvider int_two) {
		super(int_one, int_two);
	}
	
	public static final Codec<MegaOakFoliagePlacer> CODEC = RecordCodecBuilder.create( (placer) -> foliagePlacerParts(placer).apply(placer, MegaOakFoliagePlacer::new));

	@Override
	protected FoliagePlacerType<?> type() {
		return FoliagePlacerTypeRegistry.MEGA_OAK_PLACER.get();
	}

	@Override
	protected void createFoliage(LevelSimulatedReader lsr, BiConsumer<BlockPos, BlockState> blockPlacer,
			RandomSource random, TreeConfiguration tc, int maxFreeTreeHeight, FoliageAttachment attachment,
			int height, int length, int offset) {
		BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
		for (int i = 0; i<layers.size(); i++) {
			for(int j = 0; j<layers.get(i).length; j++) {
				int[] seg = layers.get(i)[j];
				for (int k = 0; k<seg[2]; k++) {
					tryPlaceLeaf(lsr, blockPlacer, random, tc, pos.setWithOffset(attachment.pos(), seg[0] + k, -i, seg[1]));
				}
			}
		}
	}

	@Override
	public int foliageHeight(RandomSource p_225601_, int p_225602_, TreeConfiguration p_225603_) {
		return 0;
	}

	@Override
	protected boolean shouldSkipLocation(RandomSource random, int xOffset, int yOffset, int zOffset,
			int radius, boolean isDoubleTrunk) {
		return false;
	}

	/*private static float squaredDistTo(float xFrom, float yFrom, float xTo, float yTo) {
		return (xTo - xFrom)*(xTo - xFrom) + (yTo - yFrom)*(yTo - yFrom);
	}
	
	private void addCircle(LevelSimulatedReader lsr, BiConsumer<BlockPos, BlockState> blockPlacer,
			RandomSource random, TreeConfiguration tc, float radius, float x, float y , float z) {
		int westhMost = (int) Math.floor(x-radius);
		int easthMost = (int) Math.ceil(x+radius);
		int northMost = (int) Math.floor(z-radius);
		int southMost = (int) Math.ceil(z+radius);
		for (int i = westhMost; i <= easthMost; i++) {
			for (int j = northMost; j <= southMost; j++) {
				if (squaredDistTo(i, j, x, z) <= radius*radius) {
					tryPlaceLeaf(lsr, blockPlacer, random, tc, new BlockPos(i,y,j));
				}
			}
		}
	}	*/
}
