package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.resources;

import net.minecraft.client.resources.IResourceManager;

public class Wrapper_IResourceManager implements Compat_IResourceManager {

	private final IResourceManager original;

	public Wrapper_IResourceManager(IResourceManager original) {
		this.original = original;
	}

	public IResourceManager getReal() {
		return original;
	}

}
