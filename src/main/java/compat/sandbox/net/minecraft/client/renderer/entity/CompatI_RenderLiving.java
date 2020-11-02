package compat.sandbox.net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.EntityLiving;

public interface CompatI_RenderLiving<T extends EntityLiving> extends CompatI_RenderLivingBase<T> {
	public RenderLiving<T> get();
}
