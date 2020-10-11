package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderOcelot;

public class CompatReal_RenderOcelot extends RenderOcelot implements CompatI_RenderOcelot {
	@SuppressWarnings("unused")
	private Compat_RenderOcelot thisFake;

	public CompatReal_RenderOcelot(Compat_RenderOcelot thisFake, RenderManager renderManager) {
		super(renderManager);
		this.thisFake = thisFake;
	}

	@Override
	public RenderOcelot get() {
		return this;
	}
}
