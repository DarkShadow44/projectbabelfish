package compat.sandbox.net.minecraftforge.fml.common;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class Wrapper_IWorldGenerator implements IWorldGenerator {
	@SuppressWarnings("unused")
	private final Compat_IWorldGenerator thisFake;

	public Wrapper_IWorldGenerator(Compat_IWorldGenerator thisFake) {
		this.thisFake = thisFake;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		// TODO
	}
}
