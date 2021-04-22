package compat.sandbox.net.minecraftforge.fml.common;

public class Compat_Loader {

	public static Compat_Loader Compat_instance() {
		return new Compat_Loader();
	}

	public Compat_ModContainer Compat_activeModContainer() {
		return new Wrapper_ModContainer();
	}

	public static boolean Compat_isModLoaded(String name) {
		return false; // TODO
	}
}
