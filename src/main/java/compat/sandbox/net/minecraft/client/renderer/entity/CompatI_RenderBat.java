package compat.sandbox.net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.entity.RenderBat;
import net.minecraft.entity.passive.EntityBat;

public interface CompatI_RenderBat extends CompatI_RenderLiving<EntityBat> {
	public RenderBat get();
}
