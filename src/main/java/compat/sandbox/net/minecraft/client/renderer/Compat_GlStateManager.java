package compat.sandbox.net.minecraft.client.renderer;

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

	public static void Compat_func_179121_F() {
		GlStateManager.popMatrix();
	}

	public static void Compat_func_187428_a(Compat_GlStateManager_SourceFactor src, Compat_GlStateManager_DestFactor dst, Compat_GlStateManager_SourceFactor src2, Compat_GlStateManager_DestFactor dst2) {
		GlStateManager.tryBlendFuncSeparate(src.getReal(), dst.getReal(), src2.getReal(), dst2.getReal());
	}

	public static void Compat_func_179131_c(float r, float g, float b, float a) {
		GlStateManager.color(r, g, b, a);
	}

	public static void Compat_func_187441_d(float width) {
		GlStateManager.glLineWidth(width);
	}

	public static void Compat_func_179090_x() {
		GlStateManager.disableTexture2D();
	}

	public static void Compat_func_179132_a(boolean p1) {
		GlStateManager.depthMask(p1);
	}

	public static void Compat_func_179098_w() {
		GlStateManager.enableTexture2D();
	}

	public static void Compat_func_179084_k() {
		GlStateManager.disableBlend();
	}
}
