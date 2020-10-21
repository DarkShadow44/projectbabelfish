package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common;

import net.minecraftforge.fml.common.ModContainer;

public class Wrapper_ModContainer implements Compat_ModContainer {

	private final ModContainer original;

	public Wrapper_ModContainer(ModContainer original) {
		this.original = original;
	}

	public ModContainer getReal() {
		return original;
	}

	@Override
	public String Compat_getModId() {
		return original.getModId();
	}
}
