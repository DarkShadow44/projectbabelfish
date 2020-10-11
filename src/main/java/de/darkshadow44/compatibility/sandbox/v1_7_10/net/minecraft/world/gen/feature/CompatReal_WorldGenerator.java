package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.world.gen.feature;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class CompatReal_WorldGenerator extends WorldGenerator implements CompatI_WorldGenerator {
	@SuppressWarnings("unused")
	private Compat_WorldGenerator thisFake;

	public CompatReal_WorldGenerator(Compat_WorldGenerator thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public WorldGenerator get() {
		return this;
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		// TODO
		return false;
	}
}
