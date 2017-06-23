package darkshadow44.compatibility.version.v1_2_5.sandbox.net.minecraft.src;

import java.util.Random;

import darkshadow44.compatibility.version.v1_2_5.shim.net.minecraft.src.MathHelperShim;

public class MathHelper {

	public static final float sin(float par0) {
		return MathHelperShim.sin(par0);
	}

	public static final float cos(float par0) {
		return MathHelperShim.cos(par0);
	}

	public static final float sqrt_float(float par0) {
		return MathHelperShim.sqrt_float(par0);
	}

	public static final float sqrt_double(double par0) {
		return MathHelperShim.sqrt_double(par0);
	}

	public static int floor_float(float par0) {
		return MathHelperShim.floor_float(par0);
	}

	public static int func_40346_b(double par0) {
		return MathHelperShim.func_40346_b(par0);
	}

	public static int floor_double(double par0) {
		return MathHelperShim.floor_double(par0);
	}

	public static long floor_double_long(double par0) {
		return MathHelperShim.floor_double_long(par0);
	}

	public static float abs(float par0) {
		return MathHelperShim.abs(par0);
	}

	public static int clamp_int(int par0, int par1, int par2) {
		return MathHelperShim.clamp_int(par0, par1, par2);
	}

	public static float clamp_float(float par0, float par1, float par2) {
		return MathHelperShim.clamp_float(par0, par1, par2);
	}

	public static double abs_max(double par0, double par2) {
		return MathHelperShim.abs_max(par0, par2);
	}

	public static int bucketInt(int par0, int par1) {
		return MathHelperShim.bucketInt(par0, par1);
	}

	public static boolean stringNullOrLengthZero(String par0Str) {
		return MathHelperShim.stringNullOrLengthZero(par0Str);
	}

	public static int getRandomIntegerInRange(Random par0Random, int par1, int par2) {
		return MathHelperShim.getRandomIntegerInRange(par0Random, par1, par2);
	}
}
