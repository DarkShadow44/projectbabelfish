package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.vertex;

import net.minecraft.client.renderer.vertex.VertexFormatElement.EnumUsage;

public enum Compat_VertexFormatElement_EnumUsage {

	NORMAL(EnumUsage.NORMAL),
	POSITION(EnumUsage.POSITION),
	COLOR(EnumUsage.COLOR),
	UV(EnumUsage.UV),
	PADDING(EnumUsage.PADDING),
	GENERIC(EnumUsage.GENERIC);

	private EnumUsage original;

	private Compat_VertexFormatElement_EnumUsage(EnumUsage original) {
		this.original = original;
	}

	public EnumUsage getReal() {
		return original;
	}

	public static Compat_VertexFormatElement_EnumUsage getFake(EnumUsage fake) {
		switch (fake) {
		case NORMAL:
			return NORMAL;
		case POSITION:
			return POSITION;
		case COLOR:
			return COLOR;
		case UV:
			return UV;
		case PADDING:
			return PADDING;
		case GENERIC:
			return GENERIC;
		default:
			throw new RuntimeException("Error: " + fake);
		}
	}

	public static Compat_VertexFormatElement_EnumUsage Compat_get_NORMAL() {
		return NORMAL;
	}

	public static Compat_VertexFormatElement_EnumUsage Compat_get_POSITION() {
		return POSITION;
	}

	public static Compat_VertexFormatElement_EnumUsage Compat_get_COLOR() {
		return COLOR;
	}

	public static Compat_VertexFormatElement_EnumUsage Compat_get_UV() {
		return UV;
	}

	public static Compat_VertexFormatElement_EnumUsage Compat_get_PADDING() {
		return PADDING;
	}

	public static Compat_VertexFormatElement_EnumUsage Compat_get_GENERIC() {
		return GENERIC;
	}

	@SuppressWarnings("deprecation")
	public int Compat_ordinal() {
		// TODO Special cases only for 1.10.2!
		switch (original) {
		case BLEND_WEIGHT:
			return 5;
		case COLOR:
			return 2;
		case GENERIC:
			return 7;
		case MATRIX:
			return 4;
		case NORMAL:
			return 1;
		case PADDING:
			return 6;
		case POSITION:
			return 0;
		case UV:
			return 3;
		default:
			throw new RuntimeException(original.toString());
		}
	}
}
