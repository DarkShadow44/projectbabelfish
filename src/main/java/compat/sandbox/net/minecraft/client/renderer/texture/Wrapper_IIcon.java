package compat.sandbox.net.minecraft.client.renderer.texture;

import compat.sandbox.net.minecraft.util.Compat_IIcon;

public class Wrapper_IIcon implements Compat_IIcon {

	private final String name;

	public Wrapper_IIcon(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
