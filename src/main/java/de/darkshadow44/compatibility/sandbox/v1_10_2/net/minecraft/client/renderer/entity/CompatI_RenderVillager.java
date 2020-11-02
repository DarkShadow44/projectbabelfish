package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.entity.RenderVillager;
import net.minecraft.entity.passive.EntityVillager;

public interface CompatI_RenderVillager extends CompatI_RenderLiving<EntityVillager> {
	public RenderVillager get();
}
