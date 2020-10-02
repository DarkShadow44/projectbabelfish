package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;

@SuppressWarnings("rawtypes")
public class Compat_RenderSnowball extends RenderSnowball {

	public Compat_RenderSnowball(RenderManager p_i46137_1_, Item p_i46137_2_, RenderItem p_i46137_3_) {
		super(p_i46137_1_, p_i46137_2_, p_i46137_3_);
	}

}
