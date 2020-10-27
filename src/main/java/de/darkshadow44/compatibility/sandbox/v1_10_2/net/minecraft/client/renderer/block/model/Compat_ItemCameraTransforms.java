package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.model;

import net.minecraft.client.renderer.block.model.ItemCameraTransforms;

public class Compat_ItemCameraTransforms {

	private final ItemCameraTransforms original;

	public Compat_ItemCameraTransforms(ItemCameraTransforms original) {
		this.original = original;
	}

	public ItemCameraTransforms getReal() {
		return original;
	}
}
