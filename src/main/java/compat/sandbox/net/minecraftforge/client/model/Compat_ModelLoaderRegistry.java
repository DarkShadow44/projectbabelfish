package compat.sandbox.net.minecraftforge.client.model;

import net.minecraftforge.client.model.ModelLoaderRegistry;

public class Compat_ModelLoaderRegistry {

	public static void Compat_registerLoader(Compat_ICustomModelLoader loader) {
		ModelLoaderRegistry.registerLoader(new Wrapper_ICustomModelLoader(loader));
	}
}
