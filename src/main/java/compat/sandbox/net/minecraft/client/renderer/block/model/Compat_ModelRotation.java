package compat.sandbox.net.minecraft.client.renderer.block.model;

import javax.vecmath.Matrix4f;

import net.minecraft.client.renderer.block.model.ModelRotation;

public enum Compat_ModelRotation {
	X0_Y0(ModelRotation.X0_Y0),
	X0_Y90(ModelRotation.X0_Y90),
	X0_Y180(ModelRotation.X0_Y180),
	X0_Y270(ModelRotation.X0_Y270),
	X90_Y0(ModelRotation.X90_Y0),
	X90_Y90(ModelRotation.X90_Y90),
	X90_Y180(ModelRotation.X90_Y180),
	X90_Y270(ModelRotation.X90_Y270),
	X180_Y0(ModelRotation.X180_Y0),
	X180_Y90(ModelRotation.X180_Y90),
	X180_Y180(ModelRotation.X180_Y180),
	X180_Y270(ModelRotation.X180_Y270),
	X270_Y0(ModelRotation.X270_Y0),
	X270_Y90(ModelRotation.X270_Y90),
	X270_Y180(ModelRotation.X270_Y180),
	X270_Y270(ModelRotation.X270_Y270);

	private ModelRotation original;

	private Compat_ModelRotation(ModelRotation original) {
		this.original = original;
	}

	public ModelRotation getReal() {
		return original;
	}

	public static Compat_ModelRotation getFake(ModelRotation real) {
		switch (real) {
		case X0_Y0:
			return X0_Y0;
		case X0_Y90:
			return X0_Y90;
		case X0_Y180:
			return X0_Y180;
		case X0_Y270:
			return X0_Y270;
		case X90_Y0:
			return X90_Y0;
		case X90_Y90:
			return X90_Y90;
		case X90_Y180:
			return X90_Y180;
		case X90_Y270:
			return X90_Y270;
		case X180_Y0:
			return X180_Y0;
		case X180_Y90:
			return X180_Y90;
		case X180_Y180:
			return X180_Y180;
		case X180_Y270:
			return X180_Y270;
		case X270_Y0:
			return X270_Y0;
		case X270_Y90:
			return X270_Y90;
		case X270_Y180:
			return X270_Y180;
		case X270_Y270:
			return X270_Y270;
		default:
			throw new RuntimeException("Not implemented " + real);
		}
	}

	public Compat_ModelRotation Compat_func_177524_a(int p1, int p2) {
		return getFake(ModelRotation.getModelRotation(p1, p2));
	}

	public Matrix4f Compat_getMatrix() {
		return original.getMatrix();
	}
}
