package com.paulerleone.varietree.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.paulerleone.varietree.grower.BirchNewTreeGrower;
import com.paulerleone.varietree.grower.OakNewTreeGrower;
import com.paulerleone.varietree.grower.SpruceNewTreeGrower;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.grower.BirchTreeGrower;
import net.minecraft.world.level.block.grower.OakTreeGrower;
import net.minecraft.world.level.block.grower.SpruceTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;

@Mixin(AbstractTreeGrower.class)
public abstract class AbstractTreeGrowerMixin{

	@Inject(method="growTree",at=@At("HEAD"),cancellable=true)
	protected void growTree(ServerLevel level, ChunkGenerator chunkgen, BlockPos pos, BlockState bs, RandomSource random, CallbackInfoReturnable<Boolean> cir) {
		if (OakTreeGrower.class.isAssignableFrom(this.getClass())) {
			AbstractMegaTreeGrower tg = new OakNewTreeGrower();
			cir.setReturnValue(tg.growTree(level, chunkgen, pos, bs, random));
		} else if (BirchTreeGrower.class.isAssignableFrom(this.getClass())) {
			AbstractTreeGrower tg = new BirchNewTreeGrower();
			cir.setReturnValue(tg.growTree(level, chunkgen, pos, bs, random));
		} else if (SpruceTreeGrower.class.isAssignableFrom(this.getClass())) {
			AbstractMegaTreeGrower tg = new SpruceNewTreeGrower();
			cir.setReturnValue(tg.growTree(level, chunkgen, pos, bs, random));
		} 
		
	}

}
