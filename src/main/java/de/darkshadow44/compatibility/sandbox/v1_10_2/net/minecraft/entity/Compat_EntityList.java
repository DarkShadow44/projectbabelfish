package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.registries.ForgeRegistry;
import net.minecraftforge.registries.GameData;

public class Compat_EntityList {
	public static String Compat_func_75617_a(int id) {
		EntityEntry entityData = GameData.getEntityRegistry().getValue(id);
		if (entityData == null) {
			return null;
		}
		return entityData.getName(); // TODO?
	}

	public static Map<Integer, Class<?>> Compat_get_field_75623_d() {
		ForgeRegistry<EntityEntry> registry = GameData.getEntityRegistry();
		Map<Integer, Class<?>> map = new HashMap<>();
		int pos = 0; // Huge TODO

		for (Entry<ResourceLocation, EntityEntry> entry : registry.getEntries()) {
			EntityEntry entity = entry.getValue();
			map.put(pos++, entity.getEntityClass());
		}

		return map;
	}

	public static HashMap<Object, Object> Compat_get_field_75627_a() {
		HashMap<Object, Object> map = new HashMap<>(); // TODO
		return map;
	}
}
