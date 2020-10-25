package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer;

import net.minecraft.client.renderer.GlStateManager;

public class Compat_GlStateManager {

	public static void Compat_func_179112_b(int p1, int p2) {
		GlStateManager.blendFunc(p1, p2);
	}

	public static void Compat_func_179147_l() {
		GlStateManager.enableBlend();
	}

	public static void Compat_func_179129_p() {
		GlStateManager.disableCull();
	}

	public static void Compat_func_179103_j(int p1) {
		GlStateManager.shadeModel(p1);
	}

	public static void Compat_func_179089_o() {
		GlStateManager.enableCull();
	}

	public static void Compat_func_179094_E() {
		GlStateManager.pushMatrix();
	}

	public static void Compat_func_179137_b(double x, double y, double z) {
		GlStateManager.translate(x, y, z);
	}
}
