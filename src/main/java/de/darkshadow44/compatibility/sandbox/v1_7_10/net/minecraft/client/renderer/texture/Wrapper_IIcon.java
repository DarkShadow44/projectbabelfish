package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.texture;

import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.util.Compat_IIcon;

public class Wrapper_IIcon implements Compat_IIcon {

	private final String name;

	public Wrapper_IIcon(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
