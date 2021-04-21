package compat.sandbox.net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.entity.RenderSprite;
import net.minecraft.entity.Entity;

public interface CompatI_RenderSnowball<T extends Entity> extends CompatI_Render<T> {
	public RenderSprite<T> get();
}
