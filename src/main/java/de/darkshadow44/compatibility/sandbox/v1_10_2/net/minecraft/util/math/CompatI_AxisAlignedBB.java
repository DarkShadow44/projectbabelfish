package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math;

import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;

public interface CompatI_AxisAlignedBB {
	public AxisAlignedBB get();

	public double get_minX();

	public double get_minY();

	public double get_minZ();

	public double get_maxX();

	public double get_maxY();

	public double get_maxZ();

	public boolean intersectsSuper(AxisAlignedBB other);

	public AxisAlignedBB offsetSuper(double x, double y, double z);

	public AxisAlignedBB growSuper(double p1);

	public AxisAlignedBB unionSuper(AxisAlignedBB bb);

	public AxisAlignedBB offsetSuper(BlockPos pos);

	public RayTraceResult calculateInterceptSuper(Vec3d start, Vec3d end);
}
