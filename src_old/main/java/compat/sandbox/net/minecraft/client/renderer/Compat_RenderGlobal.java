package compat.sandbox.net.minecraft.client.renderer;

import compat.sandbox.net.minecraft.util.math.Compat_AxisAlignedBB;
import net.minecraft.client.renderer.RenderGlobal;

public class Compat_RenderGlobal {
	public static void Compat_func_189697_a(Compat_AxisAlignedBB bb, float r, float g, float b, float a) {
		RenderGlobal.drawSelectionBoundingBox(bb.getReal(), r, g, b, a);
	}
}
