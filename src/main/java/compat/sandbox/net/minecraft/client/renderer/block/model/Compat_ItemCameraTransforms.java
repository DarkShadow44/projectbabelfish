package compat.sandbox.net.minecraft.client.renderer.block.model;

import net.minecraft.client.renderer.model.ItemCameraTransforms;

public class Compat_ItemCameraTransforms {

	private final ItemCameraTransforms original;
	private static final Compat_ItemCameraTransforms DEFAULT = new Compat_ItemCameraTransforms(ItemCameraTransforms.DEFAULT);

	public Compat_ItemCameraTransforms(ItemCameraTransforms original) {
		this.original = original;
	}

	public ItemCameraTransforms getReal() {
		return original;
	}

	public static Compat_ItemCameraTransforms Compat_get_field_178357_a() {
		return DEFAULT;
	}
}
