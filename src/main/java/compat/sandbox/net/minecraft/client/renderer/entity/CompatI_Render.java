package compat.sandbox.net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;

public interface CompatI_Render<T extends Entity> {
	public Render<T> get();
}
