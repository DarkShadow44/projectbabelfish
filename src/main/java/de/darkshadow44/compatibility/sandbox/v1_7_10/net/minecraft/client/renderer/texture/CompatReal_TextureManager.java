package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.texture;

import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.IResourceManager;

public class CompatReal_TextureManager extends TextureManager implements CompatI_TextureManager {
	@SuppressWarnings("unused")
	private Compat_TextureManager thisFake;

	public CompatReal_TextureManager(Compat_TextureManager thisFake, IResourceManager resourceManager) {
		super(resourceManager);
		this.thisFake = thisFake;
	}

	@Override
	public TextureManager get() {
		return this;
	}
}
