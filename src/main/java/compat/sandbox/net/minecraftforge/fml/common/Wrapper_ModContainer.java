package compat.sandbox.net.minecraftforge.fml.common;

import compat.core.CompatibilityMod;

public class Wrapper_ModContainer implements Compat_ModContainer {

	public Wrapper_ModContainer() {

	}

	@Override
	public String Compat_getModId() {
		return CompatibilityMod.CURRENT_LAYER.getCurrentModId(); // original.getModId();
	}
}
