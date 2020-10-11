package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;

public class CompatReal_RenderPlayer extends RenderPlayer implements CompatI_RenderPlayer {
	@SuppressWarnings("unused")
	private Compat_RenderPlayer thisFake;

	public CompatReal_RenderPlayer(Compat_RenderPlayer thisFake, RenderManager renderManager) {
		super(renderManager);
		this.thisFake = thisFake;
	}

	@Override
	public RenderPlayer get() {
		return this;
	}
}
