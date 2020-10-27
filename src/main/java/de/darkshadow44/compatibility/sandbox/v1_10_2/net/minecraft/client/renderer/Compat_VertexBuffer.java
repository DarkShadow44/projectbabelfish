package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.vertex.Compat_VertexFormat;
import net.minecraft.client.renderer.BufferBuilder;

public class Compat_VertexBuffer {

	private final BufferBuilder original;

	public Compat_VertexBuffer(BufferBuilder original) {
		this.original = original;
	}

	public BufferBuilder getReal() {
		return original;
	}

	public void Compat_func_181668_a(int p1, Compat_VertexFormat format) {
		original.begin(p1, format.getReal());
	}

	public void Compat_func_178969_c(double x, double y, double z) {
		original.setTranslation(x, y, z);
	}

	public Compat_VertexBuffer Compat_func_181662_b(double x, double y, double z) {
		original.pos(x, y, z);
		return this;
	}

	public void Compat_func_181675_d() {
		original.endVertex();
	}
}
