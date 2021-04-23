package compat.sandbox.net.minecraft.util.math;

import net.minecraft.util.math.Vec3i;

public interface CompatI_Vec3i {
	public Vec3i get();

	public int compareToSuper(Vec3i other);

	public int getXSuper();

	public int getYSuper();

	public int getZSuper();

	public int hashCodeSuper();

	public boolean equalsSuper(Object other);
}
