package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.util;

import net.minecraft.util.ResourceLocation;

public class CompatReal_ResourceLocation extends ResourceLocation {

	@SuppressWarnings("unused")
	private Compat_ResourceLocation thisFake;
	
	public CompatReal_ResourceLocation(Compat_ResourceLocation thisFake, String p1) {
		super(p1);
		this.thisFake = thisFake;
	}

}
