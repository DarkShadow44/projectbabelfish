package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderVillager;

public class CompatReal_RenderVillager extends RenderVillager implements CompatI_RenderVillager {
	@SuppressWarnings("unused")
	private Compat_RenderVillager thisFake;

	public CompatReal_RenderVillager(Compat_RenderVillager thisFake, RenderManager renderManager) {
		super(renderManager);
		this.thisFake = thisFake;
	}

	@Override
	public RenderVillager get() {
		return this;
	}
}
