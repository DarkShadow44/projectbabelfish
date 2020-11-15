package compat.sandbox.net.minecraft.util;

import net.minecraft.util.math.MathHelper;

public class Compat_MathHelper {
	public static int Compat_func_76125_a(int p1, int p2, int p3) {
		return MathHelper.clamp(p1, p2, p3);
	}

	public static double Compat_func_151237_a(double p1, double p2, double p3) {
		return MathHelper.clamp(p1, p2, p3);
	}

	public static int Compat_func_76128_c(double d) {
		return MathHelper.floor(d);
	}
}
