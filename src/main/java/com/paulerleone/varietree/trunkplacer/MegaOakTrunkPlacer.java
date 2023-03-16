package com.paulerleone.varietree.trunkplacer;

import java.util.List;
import java.util.function.BiConsumer;

import com.google.common.base.Function;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.paulerleone.varietree.registry.TrunkPlacerTypeRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer.FoliageAttachment;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

public class MegaOakTrunkPlacer extends TrunkPlacer{
	
	public static final Codec<MegaOakTrunkPlacer> CODEC = RecordCodecBuilder.create((placer)-> trunkPlacerParts(placer).apply(placer, MegaOakTrunkPlacer::new));
	
	
	public MegaOakTrunkPlacer(int p_70268_, int p_70269_, int p_70270_) {
		super(p_70268_, p_70269_, p_70270_);
	}

	@Override
	protected TrunkPlacerType<?> type() {
		return TrunkPlacerTypeRegistry.MEGA_OAK_TRUNK_PLACER.get();
	}

	@Override
	public List<FoliageAttachment> placeTrunk(LevelSimulatedReader lsr,
			BiConsumer<BlockPos, BlockState> blockPlacer, RandomSource random, int height, BlockPos pos,
			TreeConfiguration tc) {
		
		int xOff = random.nextBoolean() ? 1 : 0;
		int zOff = random.nextBoolean() ? 1 : 0;
		
		int o = (xOff+zOff) % 2;
		
		setDirtAt(lsr, blockPlacer, random, pos.below(), tc);
		setDirtAt(lsr, blockPlacer, random, pos.below().east(), tc);
		setDirtAt(lsr, blockPlacer, random, pos.below().south(), tc);
		setDirtAt(lsr, blockPlacer, random, pos.below().south().east(), tc);
		
		placeLog(lsr, blockPlacer, random, new BlockPos(pos.getX() + xOff, pos.getY() + height - 1, pos.getZ()+ zOff), tc);
		
		for(int i = height-6; i<height-1; i++){
			placeLog(lsr, blockPlacer, random, pos.offset(0,i,o), tc);
			placeLog(lsr, blockPlacer, random, pos.offset(1,i,1-o), tc);
		}
		for(int i = 0; i<height-6; i++) {
			placeLog(lsr, blockPlacer, random, pos.offset(0,i,0), tc);
			placeLog(lsr, blockPlacer, random, pos.offset(0,i,1), tc);
			placeLog(lsr, blockPlacer, random, pos.offset(1,i,0), tc);
			placeLog(lsr, blockPlacer, random, pos.offset(1,i,1), tc);
		}
		
		Function<BlockState, BlockState> toAxisX = (blockstate) -> blockstate.setValue(RotatedPillarBlock.AXIS, Direction.Axis.X);
		Function<BlockState, BlockState> toAxisZ = (blockstate) -> blockstate.setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z);
         
		for(int i = 0; i<2; i++) {
			placeLog(lsr, blockPlacer, random, pos.offset(0,height-8,-1-i), tc, toAxisZ);}
		for(int i = 0; i<2; i++) {
			placeLog(lsr, blockPlacer, random, pos.offset(1,height-8,2+i), tc, toAxisZ);}
		for(int i = 0; i<2; i++) {
			placeLog(lsr, blockPlacer, random, pos.offset(2+i,height-8,0), tc, toAxisX);}
		for(int i = 0; i<2; i++) {
			placeLog(lsr, blockPlacer, random, pos.offset(-1-i,height-8,1), tc, toAxisX);}
		
			placeLog(lsr, blockPlacer, random, pos.offset(0,height-4,-1), tc, toAxisZ);
			placeLog(lsr, blockPlacer, random, pos.offset(1,height-4,2), tc, toAxisZ);
			placeLog(lsr, blockPlacer, random, pos.offset(2,height-4,0), tc, toAxisX);
			placeLog(lsr, blockPlacer, random, pos.offset(-1,height-4,1), tc, toAxisX);
			
			if (o==1) {
				placeLog(lsr, blockPlacer, random, pos.offset(0,height-4,0), tc, toAxisZ);
				placeLog(lsr, blockPlacer, random, pos.offset(1,height-4,1), tc, toAxisZ);
			} else {
				placeLog(lsr, blockPlacer, random, pos.offset(1,height-4,0), tc, toAxisX);
				placeLog(lsr, blockPlacer, random, pos.offset(0,height-4,1), tc, toAxisX);
			}
			
		
		return List.of(new FoliagePlacer.FoliageAttachment(pos.offset(0,height,0), 0, true));
	}

}
