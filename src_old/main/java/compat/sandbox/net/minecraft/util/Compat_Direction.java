package compat.sandbox.net.minecraft.util;

public class Compat_Direction {

	private static final int[] offsetX = new int[] { 0, -1, 0, 1 };
	public static final int[] offsetZ = new int[] { 1, 0, -1, 0 };
	public static final int[] directionToFacing = new int[] { 3, 4, 2, 5 };
	public static final int[] facingToDirection = new int[] { -1, -1, 2, 0, 1, 3 };
	public static final int[] rotateOpposite = new int[] { 2, 3, 0, 1 };
	public static final int[] rotateRight = new int[] { 1, 2, 3, 0 };
	public static final int[] rotateLeft = new int[] { 3, 0, 1, 2 };

	public int[] Compat_get_field_71577_f() {
		return rotateRight;
	}

	public int[] Compat_get_field_71578_g() {
		return rotateLeft;
	}

	public int[] Compat_get_field_71579_d() {
		return facingToDirection;
	}

	public int[] Compat_get_field_71580_e() {
		return rotateOpposite;
	}

	public int[] Compat_get_field_71582_c() {
		return directionToFacing;
	}

	public int[] Compat_get_field_71583_a() {
		return offsetX;
	}

	public int[] Compat_get_field_71581_b() {
		return offsetZ;
	}
}
