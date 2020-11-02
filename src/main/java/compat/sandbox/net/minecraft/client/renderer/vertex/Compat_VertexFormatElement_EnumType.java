package compat.sandbox.net.minecraft.client.renderer.vertex;

import net.minecraft.client.renderer.vertex.VertexFormatElement.EnumType;

public enum Compat_VertexFormatElement_EnumType {
	FLOAT(EnumType.FLOAT),
	UBYTE(EnumType.UBYTE),
	BYTE(EnumType.BYTE),
	USHORT(EnumType.USHORT),
	SHORT(EnumType.SHORT),
	UINT(EnumType.UINT),
	INT(EnumType.INT);

	private EnumType original;

	private Compat_VertexFormatElement_EnumType(EnumType original) {
		this.original = original;
	}

	public static Compat_VertexFormatElement_EnumType getFake(EnumType real) {
		switch (real) {
		case FLOAT:
			return FLOAT;
		case UBYTE:
			return UBYTE;
		case BYTE:
			return BYTE;
		case USHORT:
			return USHORT;
		case SHORT:
			return SHORT;
		case UINT:
			return UINT;
		case INT:
			return INT;

		default:
			throw new RuntimeException();
		}
	}

	public EnumType getReal() {
		return original;
	}

	public static Compat_VertexFormatElement_EnumType Compat_get_FLOAT() {
		return FLOAT;
	}

	public static Compat_VertexFormatElement_EnumType Compat_get_UBYTE() {
		return UBYTE;
	}

	public static Compat_VertexFormatElement_EnumType Compat_get_BYTE() {
		return BYTE;
	}

	public static Compat_VertexFormatElement_EnumType Compat_get_USHORT() {
		return USHORT;
	}

	public static Compat_VertexFormatElement_EnumType Compat_get_SHORT() {
		return SHORT;
	}

	public static Compat_VertexFormatElement_EnumType Compat_get_UINT() {
		return UINT;
	}

	public static Compat_VertexFormatElement_EnumType Compat_get_INT() {
		return INT;
	}
}
