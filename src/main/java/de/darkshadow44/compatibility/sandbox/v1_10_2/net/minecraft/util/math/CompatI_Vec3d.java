package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math;

import net.minecraft.util.math.Vec3d;

public interface CompatI_Vec3d {
	public Vec3d get();

	public double get_x();

	public double get_y();

	public double get_z();

	public Vec3d addVectorSuper(double x, double y, double z);

	public double squareDistanceToSuper(Vec3d vec);
}
