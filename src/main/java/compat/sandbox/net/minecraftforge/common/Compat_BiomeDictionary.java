package compat.sandbox.net.minecraftforge.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import compat.sandbox.net.minecraft.world.biome.Compat_Biome;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

public class Compat_BiomeDictionary {
	public static Compat_Biome[] Compat_getBiomesForType(Compat_BiomeDictionary_Type type) {
		Set<Biome> biomes = BiomeDictionary.getBiomes(type.getReal());

		List<Compat_Biome> biomesConverted = new ArrayList<>();

		for (Biome biome : biomes) {
			biomesConverted.add(new Compat_Biome(biome));
		}

		return biomesConverted.toArray(new Compat_Biome[0]);
	}
}
