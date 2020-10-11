package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
 
public class CompatReal_RenderBiped<T extends EntityLiving> extends RenderBiped<T> implements CompatI_RenderBiped<T> {
	@SuppressWarnings("unused")
	private Compat_RenderBiped<T> thisFake;

	public CompatReal_RenderBiped(Compat_RenderBiped<T> thisFake, RenderManager renderManager, ModelBiped model, float p1) {
		super(renderManager, model, p1);
		this.thisFake = thisFake;
	}

	@Override
	public RenderBiped<T> get() {
		return this;
	}
}
