package compat.sandbox.net.minecraft.util.math;

import net.minecraft.util.math.RayTraceResult.Type;

public enum Compat_RayTraceResult_Type {

	BLOCK(Type.BLOCK),
	ENTITY(Type.ENTITY),
	MISS(Type.MISS);

	private Type original;

	private Compat_RayTraceResult_Type(Type original) {
		this.original = original;
	}

	public Type getReal() {
		return original;
	}

	public static Compat_RayTraceResult_Type getFake(Type real) {
		switch (real) {
		case BLOCK:
			return BLOCK;
		case ENTITY:
			return ENTITY;
		case MISS:
			return MISS;
		default:
			return null;
		}
	}

	public static Compat_RayTraceResult_Type Compat_get_BLOCK() {
		return BLOCK;
	}

	public static Compat_RayTraceResult_Type Compat_get_ENTITY() {
		return ENTITY;
	}

	public static Compat_RayTraceResult_Type Compat_get_MISS() {
		return MISS;
	}
}
