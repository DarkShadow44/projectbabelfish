package compat.sandbox.net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.EntityLiving;

public interface CompatI_RenderBiped<T extends EntityLiving> extends CompatI_RenderLiving<T> {
	public RenderBiped<T> get();
}
