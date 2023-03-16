package com.paulerleone.varietree.foliageplacer;

import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;

public abstract class ModFoliagePlacer extends FoliagePlacer{

	public ModFoliagePlacer(IntProvider int_one, IntProvider int_two) {
		super(int_one, int_two);
	}

}
