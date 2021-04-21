package compat.sandbox.net.minecraft.client.gui;

import net.minecraft.client.Minecraft;

public class Compat_ScaledResolution {

	public Compat_ScaledResolution() {
	}

	public int Compat_func_78326_a() {
		return Minecraft.getInstance().mainWindow.getScaledWidth();
	}

	public int Compat_func_78328_b() {
		return Minecraft.getInstance().mainWindow.getScaledHeight();
	}
}
