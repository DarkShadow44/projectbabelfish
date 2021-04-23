package compat.sandbox.net.minecraftforge.common.model;

import net.minecraftforge.common.model.TRSRTransformation;

public class Compat_TRSRTransformation {

	@SuppressWarnings("unused")
	private final TRSRTransformation original;

	public Compat_TRSRTransformation(TRSRTransformation original) {
		this.original = original;
	}

	public static Compat_TRSRTransformation Compat_identity() {
		return new Compat_TRSRTransformation(TRSRTransformation.identity());
	}

	public static org.lwjgl.util.vector.Matrix4f Compat_toLwjgl(javax.vecmath.Matrix4f mat) {
		return TRSRTransformation.toLwjgl(mat);
	}
}
