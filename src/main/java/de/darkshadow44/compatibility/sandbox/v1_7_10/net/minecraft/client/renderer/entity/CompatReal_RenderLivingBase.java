package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class CompatReal_RenderLivingBase<T extends EntityLivingBase> extends RenderLivingBase<T> implements CompatI_RenderLivingBase<T> {
	@SuppressWarnings("unused")
	private Compat_RenderLivingBase<T> thisFake;

	public CompatReal_RenderLivingBase(Compat_RenderLivingBase<T> thisFake, RenderManager renderManager, ModelBase model, float p1) {
		super(renderManager, model, p1);
		this.thisFake = thisFake;
	}

	@Override
	public RenderLivingBase<T> get() {
		return this;
	}

	@Override
	protected ResourceLocation getEntityTexture(T arg0) {
		// TODO
		return null;
	}
}
