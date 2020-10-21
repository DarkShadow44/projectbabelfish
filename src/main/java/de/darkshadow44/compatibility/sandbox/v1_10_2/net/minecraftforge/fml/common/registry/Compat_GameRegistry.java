package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.registry;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Compat_GameRegistry {

	public static Compat_IForgeRegistryEntry Compat_register(Compat_IForgeRegistryEntry p1, Compat_ResourceLocation p2) {
		// TODO
		return null;
	}

	public static void Compat_registerTileEntityWithAlternatives(Class<? extends TileEntity> tileEntityClass, String id, String... alternatives) {
		GameRegistry.registerTileEntity(tileEntityClass, new ResourceLocation(id));
		// TODO
	}

	public static void Compat_registerTileEntity(Class<? extends TileEntity> clazz, String key) {
		GameRegistry.registerTileEntity(clazz, new ResourceLocation(key));
	}
}
