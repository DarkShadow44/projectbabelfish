package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common;

import net.minecraftforge.fml.common.Loader;

public class Compat_Loader {

	private final Loader original;

	public Compat_Loader(Loader original) {
		this.original = original;
	}

	public Loader getReal() {
		return original;
	}

	public static Compat_Loader Compat_instance() {
		return new Compat_Loader(Loader.instance());
	}

	public Compat_ModContainer Compat_activeModContainer() {
		return new Wrapper_ModContainer(original.activeModContainer());
	}
}
