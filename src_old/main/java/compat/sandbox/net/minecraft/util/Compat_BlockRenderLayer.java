package compat.sandbox.net.minecraft.util;

import net.minecraft.util.BlockRenderLayer;

public enum Compat_BlockRenderLayer {

	SOLID(BlockRenderLayer.SOLID),
	CUTOUT_MIPPED(BlockRenderLayer.CUTOUT_MIPPED),
	CUTOUT(BlockRenderLayer.CUTOUT),
	TRANSLUCENT(BlockRenderLayer.TRANSLUCENT);

	private BlockRenderLayer original;

	private Compat_BlockRenderLayer(BlockRenderLayer original) {
		this.original = original;
	}

	public BlockRenderLayer getReal() {
		return original;
	}

	public static Compat_BlockRenderLayer getFake(BlockRenderLayer real) {
		switch (real) {
		case SOLID:
			return SOLID;
		case CUTOUT_MIPPED:
			return CUTOUT_MIPPED;
		case CUTOUT:
			return CUTOUT;
		case TRANSLUCENT:
			return TRANSLUCENT;
		default:
			throw new RuntimeException();
		}
	}

	public static Compat_BlockRenderLayer Compat_get_SOLID() {
		return SOLID;
	}

	public static Compat_BlockRenderLayer Compat_get_CUTOUT_MIPPED() {
		return CUTOUT_MIPPED;
	}

	public static Compat_BlockRenderLayer Compat_get_CUTOUT() {
		return CUTOUT;
	}

	public static Compat_BlockRenderLayer Compat_get_TRANSLUCENT() {
		return TRANSLUCENT;
	}
}
