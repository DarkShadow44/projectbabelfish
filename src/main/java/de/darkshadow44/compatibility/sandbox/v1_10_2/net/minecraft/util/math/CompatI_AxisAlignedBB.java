package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math;

import net.minecraft.util.math.AxisAlignedBB;

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
}
