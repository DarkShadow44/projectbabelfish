package compat.sandbox.net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.entity.RenderOcelot;
import net.minecraft.entity.passive.EntityOcelot;

public interface CompatI_RenderOcelot extends CompatI_RenderLiving<EntityOcelot> {
	public RenderOcelot get();
}
