package darkshadow44.compatibility.version.v1_2_5.shim.net.minecraft.src;

import java.util.Random;

import net.minecraft.util.MathHelper;

public class MathHelperShim {
	public static final float sin(float par0) {
		return MathHelper.sin(par0);
	}

	public static final float cos(float par0) {
		return MathHelper.cos(par0);
	}

	public static final float sqrt_float(float par0) {
		return MathHelper.sqrt_float(par0);
	}

	public static final float sqrt_double(double par0) {
		return MathHelper.sqrt_double(par0);
	}

	public static int floor_float(float par0) {
		return MathHelper.floor_float(par0);
	}

	public static int func_40346_b(double par0) {
		throw new RuntimeException("Not Implemented.");
	}

	public static int floor_double(double par0) {
		return MathHelper.floor_double(par0);
	}

	public static long floor_double_long(double par0) {
		return MathHelper.floor_double_long(par0);
	}

	public static float abs(float par0) {
		return MathHelper.abs(par0);
	}

	public static int clamp_int(int par0, int par1, int par2) {
		return MathHelper.clamp_int(par0, par1, par2);
	}

	public static float clamp_float(float par0, float par1, float par2) {
		return MathHelper.clamp_float(par0, par1, par2);
	}

	public static double abs_max(double par0, double par2) {
		return MathHelper.abs_max(par0, par2);
	}

	public static int bucketInt(int par0, int par1) {
		return MathHelper.bucketInt(par0, par1);
	}

	public static boolean stringNullOrLengthZero(String par0Str) {
		return MathHelper.stringNullOrLengthZero(par0Str);
	}

	public static int getRandomIntegerInRange(Random par0Random, int par1, int par2) {
		return MathHelper.getRandomIntegerInRange(par0Random, par1, par2);
	}
}
