package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.util;

public class Compat_ResourceLocation {

	public CompatReal_ResourceLocation thisReal;

	public Compat_ResourceLocation(String p1) {
		thisReal = new CompatReal_ResourceLocation(this, p1);
	}
}
