package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.entity.RenderBat;
import net.minecraft.client.renderer.entity.RenderManager;

public class CompatReal_RenderBat extends RenderBat implements CompatI_RenderBat {
	@SuppressWarnings("unused")
	private Compat_RenderBat thisFake;

	public CompatReal_RenderBat(Compat_RenderBat thisFake, RenderManager renderManager) {
		super(renderManager);
		this.thisFake = thisFake;
	}

	@Override
	public RenderBat get() {
		return this;
	}
}
