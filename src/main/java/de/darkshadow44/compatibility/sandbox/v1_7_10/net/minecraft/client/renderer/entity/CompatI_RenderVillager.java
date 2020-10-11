package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.entity.RenderVillager;
import net.minecraft.entity.passive.EntityVillager;

public interface CompatI_RenderVillager extends CompatI_RenderLiving<EntityVillager> {
	public RenderVillager get();
}
