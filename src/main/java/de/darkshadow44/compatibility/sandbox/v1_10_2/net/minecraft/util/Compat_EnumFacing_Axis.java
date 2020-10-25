package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util;

import net.minecraft.util.EnumFacing.Axis;

public enum Compat_EnumFacing_Axis {

	X(Axis.X), Y(Axis.Y), Z(Axis.Z);

	private Axis original;

	private Compat_EnumFacing_Axis(Axis original) {
		this.original = original;
	}

	public Axis getReal() {
		return original;
	}

	public static Compat_EnumFacing_Axis Compat_get_X() {
		return X;
	}

	public static Compat_EnumFacing_Axis Compat_get_Y() {
		return Y;
	}

	public static Compat_EnumFacing_Axis Compat_get_Z() {
		return Z;
	}
}
