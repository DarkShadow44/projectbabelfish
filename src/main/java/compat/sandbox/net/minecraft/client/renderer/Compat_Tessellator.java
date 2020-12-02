package compat.sandbox.net.minecraft.client.renderer;

import java.util.ArrayList;
import java.util.List;

import compat.mixinhelper.ForgeBlockModelRendererHelper;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.BufferBuilder.State;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.math.BlockPos;

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

	private static BufferBuilder bufferOld;
	private static float oldR, oldG, oldB;
	private static float oldX, oldY, oldZ;
	private static int oldBright;
	private static boolean isBlock;

	public static Compat_Tessellator Compat_get_field_78398_a() {
		return instanceOld;
	}

	// setBrightness
	public void Compat_func_78380_c(int brightness) {
		oldBright = brightness;
	}

	// setColorOpaque_F
	public void Compat_func_78386_a(float r, float g, float b) {
		oldR = r;
		oldG = g;
		oldB = b;
	}

	// addVertexWithUV
	public void Compat_func_78374_a(double x, double y, double z, double u, double v) {
		if (isBlock) {
			BlockPos pos = ForgeBlockModelRendererHelper.currentPos;
			bufferOld.pos(x - pos.getX(), y - pos.getY(), z - pos.getZ());
		} else {
			bufferOld.pos(x, y, z);
		}

		bufferOld.setTranslation(oldX, oldY, oldZ);
		bufferOld.color(oldR, oldG, oldB, 0.5f);
		bufferOld.tex(u, v);
		bufferOld.tex(oldBright >> 16, oldBright);
		bufferOld.endVertex();
	}

	private static VertexFormat format = DefaultVertexFormats.BLOCK;

	public static void resetForISBRH(boolean isBlock) {
		Compat_Tessellator.isBlock = isBlock;
		bufferOld = new BufferBuilder(1000);
		bufferOld.begin(0, format);

		oldR = 0;
		oldG = 0;
		oldB = 0;
		oldBright = 0;
		oldX = 0;
		oldY = 0;
		oldZ = 0;
	}

	private static void getRaw(int[] source, int[] dest, int face) {
		int sizeFace = format.getIntegerSize() * 4;
		for (int i = 0; i < sizeFace; i++) {
			dest[i] = source[face * sizeFace + i];
		}
	}

	public static List<BakedQuad> getQuads() {
		State state = bufferOld.getVertexState();

		int vertexCount = state.getVertexCount();
		int countFaces = vertexCount / 4;
		int[] vertexRaw = state.getRawBuffer();

		List<BakedQuad> ret = new ArrayList<>();

		for (int i = 0; i < countFaces; i++) {
			int[] buf = new int[format.getIntegerSize() * 4];
			getRaw(vertexRaw, buf, i);

			ret.add(new BakedQuad(buf, 0, null, null, true, format));
		}

		return ret;
	}

	public void Compat_func_78382_b() {
		// startDrawingQuads
	}

	public void Compat_func_78375_b(float x, float y, float z) {
		// setNormal
	}

	public int Compat_func_78381_a_I() {
		// draw
		return 0;
	}

	public static void glTranslate(float x, float y, float z) {
		oldX += x;
		oldY += y;
		oldZ += z;
	}

}
