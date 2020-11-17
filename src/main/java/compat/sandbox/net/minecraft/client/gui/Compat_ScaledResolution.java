package compat.sandbox.net.minecraft.client.gui;

import net.minecraft.client.gui.ScaledResolution;

public class Compat_ScaledResolution {

	private final ScaledResolution original;

	public Compat_ScaledResolution(ScaledResolution original) {
		this.original = original;
	}

	public int Compat_func_78326_a() {
		return original.getScaledWidth();
	}

	public int Compat_func_78328_b() {
		return original.getScaledHeight();
	}
}
