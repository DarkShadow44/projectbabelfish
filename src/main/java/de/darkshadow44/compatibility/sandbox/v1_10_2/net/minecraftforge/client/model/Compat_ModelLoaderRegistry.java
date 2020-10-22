package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.client.model;

import net.minecraftforge.client.model.ModelLoaderRegistry;

public class Compat_ModelLoaderRegistry {

	public static void Compat_registerLoader(Compat_ICustomModelLoader loader) {
		ModelLoaderRegistry.registerLoader(new Wrapper_ICustomModelLoader(loader));
	}
}
