package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class CompatReal_Render<T extends Entity> extends Render<T> implements CompatI_Render<T> {
	@SuppressWarnings("unused")
	private Compat_Render<T> thisFake;

	public CompatReal_Render(Compat_Render<T> thisFake, RenderManager manager) {
		super(manager);
		this.thisFake = thisFake;
	}

	@Override
	public Render<T> get() {
		return this;
	}

	@Override
	protected ResourceLocation getEntityTexture(T arg0) {
		// TODO
		return null;
	}
}
