package compat.sandbox.net.minecraft.client.renderer;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraftforge.client.model.pipeline.UnpackedBakedQuad.Builder;

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

	public Compat_BufferBuilder Compat_func_178180_c() {
		return new Compat_BufferBuilder(original.getBuffer());
	}

	public void Compat_func_78381_a() {
		original.draw();
	}

	private static Compat_Tessellator instanceOld = new Compat_Tessellator(null); // Instance of 1.7.10

	private Builder builderOld = new Builder(DefaultVertexFormats.BLOCK);
	private BufferBuilder bufferOld = new BufferBuilder(0);

	public static Compat_Tessellator Compat_get_field_78398_a() {
		return instanceOld;
	}

	public void Compat_func_78380_c(int brightness) {
		// Ignore?
	}

}
