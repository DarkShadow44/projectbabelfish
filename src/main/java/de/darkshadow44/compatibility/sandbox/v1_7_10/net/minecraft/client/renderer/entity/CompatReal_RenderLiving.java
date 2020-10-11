package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class CompatReal_RenderLiving<T extends EntityLiving> extends RenderLiving<T> implements CompatI_RenderLiving<T> {
	@SuppressWarnings("unused")
	private Compat_RenderLiving<T> thisFake;

	public CompatReal_RenderLiving(Compat_RenderLiving<T> thisFake, RenderManager renderManager, ModelBase modelBase, float p1) {
		super(renderManager, modelBase, p1);
		this.thisFake = thisFake;
	}

	@Override
	public RenderLiving<T> get() {
		return this;
	}

	@Override
	protected ResourceLocation getEntityTexture(T arg0) {
		// TODO
		return null;
	}
}
