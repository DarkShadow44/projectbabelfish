package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.vertex;

import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

public class Compat_DefaultVertexFormats {
	private static final Compat_VertexFormat BLOCK = new Compat_VertexFormat(DefaultVertexFormats.BLOCK);
	private static final Compat_VertexFormat POSITION = new Compat_VertexFormat(DefaultVertexFormats.POSITION);

	public static Compat_VertexFormat Compat_get_field_176600_a() {
		return BLOCK;
	}

	public static Compat_VertexFormat Compat_get_field_181705_e() {
		return POSITION;
	}
}
