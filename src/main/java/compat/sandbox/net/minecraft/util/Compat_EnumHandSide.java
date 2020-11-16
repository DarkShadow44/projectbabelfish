package compat.sandbox.net.minecraft.util;

import net.minecraft.util.EnumHandSide;

public enum Compat_EnumHandSide {

	LEFT(EnumHandSide.LEFT),
	RIGHT(EnumHandSide.RIGHT);

	private EnumHandSide original;

	private Compat_EnumHandSide(EnumHandSide original) {
		this.original = original;
	}

	public Compat_EnumHandSide getFake(EnumHandSide real) {
		switch (real) {
		case LEFT:
			return LEFT;
		case RIGHT:
			return RIGHT;
		default:
			throw new RuntimeException();
		}
	}

	public EnumHandSide getReal() {
		return original;
	}

	public static Compat_EnumHandSide Compat_get_LEFT() {
		return LEFT;
	}

	public static Compat_EnumHandSide Compat_get_RIGHT() {
		return RIGHT;
	}

	public Compat_EnumHandSide Compat_func_188468_a() {
		return getFake(original.opposite());
	}
}
