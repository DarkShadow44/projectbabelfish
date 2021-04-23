package compat.sandbox.net.minecraft.world.biome;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;

public interface CompatI_Biome {
	public Biome get();

	public String getBiomeNameSuper();

	public float getRainfallSuper();

	public float getDefaultTemperatureSuper();

	public int getFoliageColorAtPosSuper(BlockPos pos);

	public int getGrassColorAtPosSuper(BlockPos pos);
}
