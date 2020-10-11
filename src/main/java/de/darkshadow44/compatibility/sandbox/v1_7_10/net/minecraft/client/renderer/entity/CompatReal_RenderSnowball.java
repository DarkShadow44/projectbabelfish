package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;

public class CompatReal_RenderSnowball<T extends Entity> extends RenderSnowball<T> implements CompatI_RenderSnowball<T> {
	@SuppressWarnings("unused")
	private Compat_RenderSnowball<T> thisFake;

	public CompatReal_RenderSnowball(Compat_RenderSnowball<T> thisFake, RenderManager renderManager, Item item, RenderItem renderItem) {
		super(renderManager, item, renderItem);
		this.thisFake = thisFake;
	}

	@Override
	public RenderSnowball<T> get() {
		return this;
	}
}
