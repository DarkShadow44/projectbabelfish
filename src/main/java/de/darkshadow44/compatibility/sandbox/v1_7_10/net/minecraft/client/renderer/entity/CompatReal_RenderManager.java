package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureManager;

public class CompatReal_RenderManager extends RenderManager implements CompatI_RenderManager {
	@SuppressWarnings("unused")
	private Compat_RenderManager thisFake;

	public CompatReal_RenderManager(Compat_RenderManager thisFake, TextureManager textureManager, RenderItem itemRenderer) {
		super(textureManager, itemRenderer);
		this.thisFake = thisFake;
	}

	@Override
	public RenderManager get() {
		return this;
	}
}
