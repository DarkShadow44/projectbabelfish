package compat.sandbox.net.minecraft.client.renderer.texture;

import compat.sandbox.net.minecraft.util.Compat_IIcon;
import net.minecraft.util.ResourceLocation;

public class Wrapper_IIcon implements Compat_IIcon {

	private final ResourceLocation location;

	public Wrapper_IIcon(ResourceLocation location) {
		this.location = location;
	}

	public ResourceLocation getLocation() {
		return location;
	}
}
