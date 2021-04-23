package compat.sandbox.net.minecraft.client.renderer.vertex;

import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

public class Compat_DefaultVertexFormats {
	private static final Compat_VertexFormat BLOCK = new Compat_VertexFormat(DefaultVertexFormats.BLOCK);
	private static final Compat_VertexFormat POSITION = new Compat_VertexFormat(DefaultVertexFormats.POSITION);
	private static final Compat_VertexFormat OLDMODEL_POSITION_TEX_NORMAL = new Compat_VertexFormat(DefaultVertexFormats.OLDMODEL_POSITION_TEX_NORMAL);

	public static Compat_VertexFormat Compat_get_field_176600_a() {
		return BLOCK;
	}

	public static Compat_VertexFormat Compat_get_field_181705_e() {
		return POSITION;
	}

	public static Compat_VertexFormat Compat_get_field_181703_c() {
		return OLDMODEL_POSITION_TEX_NORMAL;
	}

}
