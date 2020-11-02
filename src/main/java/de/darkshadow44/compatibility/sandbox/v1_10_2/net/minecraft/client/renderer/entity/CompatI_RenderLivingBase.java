package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.EntityLivingBase;

public interface CompatI_RenderLivingBase<T extends EntityLivingBase> extends CompatI_Render<T> {
	public RenderLivingBase<T> get();
}
