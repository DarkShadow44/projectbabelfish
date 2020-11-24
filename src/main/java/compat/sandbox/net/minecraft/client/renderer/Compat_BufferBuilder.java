package compat.sandbox.net.minecraft.client.renderer;

import compat.sandbox.net.minecraft.client.renderer.vertex.Compat_VertexFormat;
import net.minecraft.client.renderer.BufferBuilder;

public class Compat_BufferBuilder {

	private final BufferBuilder original;

	public Compat_BufferBuilder(BufferBuilder original) {
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

	public Compat_BufferBuilder Compat_func_181662_b(double x, double y, double z) {
		original.pos(x, y, z);
		return this;
	}

	public void Compat_func_181675_d() {
		original.endVertex();
	}

	public void Compat_func_78914_f() {
		original.noColor();
	}
}
