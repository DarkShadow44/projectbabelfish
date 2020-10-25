package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer;

import net.minecraft.client.renderer.RenderHelper;

public class Compat_RenderHelper {
	public static void Compat_func_74518_a() {
		RenderHelper.disableStandardItemLighting();
	}

	public static void Compat_func_74519_b() {
		RenderHelper.enableStandardItemLighting();
	}
}
