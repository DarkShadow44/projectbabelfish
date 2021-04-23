package compat.sandbox.net.minecraft.world.biome;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProvider;

public interface CompatI_BiomeProvider {
	public BiomeProvider get();

	public Biome getBiomeSuper(BlockPos pos);
}
