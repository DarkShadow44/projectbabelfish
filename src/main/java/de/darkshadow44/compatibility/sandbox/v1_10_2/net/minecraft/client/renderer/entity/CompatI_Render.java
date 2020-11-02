package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;

public interface CompatI_Render<T extends Entity> {
	public Render<T> get();
}
