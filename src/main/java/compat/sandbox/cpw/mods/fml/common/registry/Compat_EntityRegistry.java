package compat.sandbox.cpw.mods.fml.common.registry;

import java.util.ArrayList;
import java.util.List;

import compat.sandbox.net.minecraft.entity.Compat_Entity;
import compat.sandbox.net.minecraft.entity.Compat_EnumCreatureType;
import compat.sandbox.net.minecraft.world.biome.Compat_BiomeGenBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.world.biome.Biome;

public class Compat_EntityRegistry {
	public static void Compat_registerModEntity(Class<? extends Compat_Entity> entityClass, String entityName, int id, Object mod, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates) {
		// TODO
	}

	public static void Compat_addSpawn(Class<? extends EntityLiving> entityClass, int weightedProb, int min, int max, Compat_EnumCreatureType typeOfCreature, Compat_BiomeGenBase[] biomes) {
		List<Biome> biomesConverted = new ArrayList<>();

		for (Compat_BiomeGenBase biome : biomes) {
			biomesConverted.add(biome.getReal());
		}

		// TODO need wrapper for entity...
		// EntityRegistry.addSpawn(entityClass, weightedProb, min, max,
		// typeOfCreature.getReal(), biomesConverted.toArray(new Biome[0]));
	}
}
