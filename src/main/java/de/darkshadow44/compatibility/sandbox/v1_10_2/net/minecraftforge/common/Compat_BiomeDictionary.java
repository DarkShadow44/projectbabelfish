package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world.biome.Compat_BiomeGenBase;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

public class Compat_BiomeDictionary {
	public static Compat_BiomeGenBase[] Compat_getBiomesForType(Compat_BiomeDictionary_Type type) {
		Set<Biome> biomes = BiomeDictionary.getBiomes(type.getReal());

		List<Compat_BiomeGenBase> biomesConverted = new ArrayList<>();

		for (Biome biome : biomes) {
			biomesConverted.add(new Compat_BiomeGenBase(biome));
		}

		return biomesConverted.toArray(new Compat_BiomeGenBase[0]);
	}
}
