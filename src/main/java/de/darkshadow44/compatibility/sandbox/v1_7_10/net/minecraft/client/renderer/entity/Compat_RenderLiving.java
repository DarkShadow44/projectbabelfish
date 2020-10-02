package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;

@SuppressWarnings("rawtypes")
public abstract class Compat_RenderLiving extends RenderLiving {

	public Compat_RenderLiving(RenderManager p_i46153_1_, ModelBase p_i46153_2_, float p_i46153_3_) {
		super(p_i46153_1_, p_i46153_2_, p_i46153_3_);
	}

}
