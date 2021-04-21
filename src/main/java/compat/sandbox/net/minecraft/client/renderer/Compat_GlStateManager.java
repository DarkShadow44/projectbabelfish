package compat.sandbox.net.minecraft.client.renderer;

import java.nio.FloatBuffer;

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
		GlStateManager.translated(x, y, z);
	}

	public static void Compat_func_179121_F() {
		GlStateManager.popMatrix();
	}

	public static void Compat_func_187428_a(Compat_GlStateManager_SourceFactor src, Compat_GlStateManager_DestFactor dst, Compat_GlStateManager_SourceFactor src2, Compat_GlStateManager_DestFactor dst2) {
		GlStateManager.blendFuncSeparate(src.getReal(), dst.getReal(), src2.getReal(), dst2.getReal());
	}

	public static void Compat_func_179131_c(float r, float g, float b, float a) {
		GlStateManager.color4f(r, g, b, a);
	}

	public static void Compat_func_187441_d(float width) {
		GlStateManager.lineWidth(width);
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

	public static void Compat_func_179088_q() {
		GlStateManager.enablePolygonOffset();
	}

	public static void Compat_func_179092_a(int p1, float p2) {
		GlStateManager.alphaFunc(p1, p2);
	}

	public static void Compat_func_179101_C() {
		GlStateManager.disableRescaleNormal();
	}

	public static void Compat_func_179109_b(float x, float y, float z) {
		GlStateManager.translatef(x, y, z);
	}

	public static void Compat_func_179110_a(FloatBuffer p1) {
		GlStateManager.multMatrixf(p1);
	}

	public static void Compat_func_179113_r() {
		GlStateManager.disablePolygonOffset();
	}

	public static void Compat_func_179118_c() {
		GlStateManager.disableAlphaTest();
	}

	public static void Compat_func_179120_a(int p1, int p2, int p3, int p4) {
		GlStateManager.blendFuncSeparate(p1, p2, p3, p4);
	}

	public static void Compat_func_179136_a(float p1, float p2) {
		GlStateManager.polygonOffset(p1, p2);
	}

	public static void Compat_func_179139_a(double x, double y, double z) {
		GlStateManager.scaled(x, y, z);
	}

	public static void Compat_func_179141_d() {
		GlStateManager.enableAlphaTest();
	}

	public static void Compat_func_179152_a(float x, float y, float z) {
		GlStateManager.scalef(x, y, z);
	}

	public static void Compat_func_187401_a(Compat_GlStateManager_SourceFactor src, Compat_GlStateManager_DestFactor dst) {
		GlStateManager.blendFunc(src.getReal(), dst.getReal());
	}

}
