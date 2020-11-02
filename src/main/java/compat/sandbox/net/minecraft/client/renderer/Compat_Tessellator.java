package compat.sandbox.net.minecraft.client.renderer;

import net.minecraft.client.renderer.Tessellator;

public class Compat_Tessellator {
	private final Tessellator original;

	public Compat_Tessellator(Tessellator original) {
		this.original = original;
	}

	public Tessellator getReal() {
		return original;
	}

	public static Compat_Tessellator Compat_func_178181_a() {
		return new Compat_Tessellator(Tessellator.getInstance());
	}

	public Compat_VertexBuffer Compat_func_178180_c() {
		return new Compat_VertexBuffer(original.getBuffer());
	}

	public void Compat_func_78381_a() {
		original.draw();
	}
}
