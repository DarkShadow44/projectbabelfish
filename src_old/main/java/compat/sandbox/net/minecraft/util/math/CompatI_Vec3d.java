package compat.sandbox.net.minecraft.util.math;

import net.minecraft.util.math.Vec3d;

public interface CompatI_Vec3d {
	public Vec3d get();

	public double get_x();

	public double get_y();

	public double get_z();

	public Vec3d addVectorSuper(double x, double y, double z);

	public double squareDistanceToSuper(Vec3d vec);

	public Vec3d subtractSuper(double x, double y, double z);

	public Vec3d addSuper(Vec3d other);

	public Vec3d subtractSuper(Vec3d other);

	public Vec3d scaleSuper(double factor);

	public Vec3d crossProductSuper(Vec3d vec);

	public Vec3d normalizeSuper();
}
