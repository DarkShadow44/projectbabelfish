package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.Entity;

public interface CompatI_RenderSnowball<T extends Entity> extends CompatI_Render<T> {
	public RenderSnowball<T> get();
}
