package compat.sandbox.net.minecraft.util.math;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.RayTraceResult.Type;
import net.minecraft.util.math.Vec3d;

public interface CompatI_RayTraceResult {
	public RayTraceResult get();

	public Type get_typeOfHit();

	public BlockPos getBlockPosSuper();

	public Vec3d get_hitVec();

	public EnumFacing get_sideHit();

	public void set_subHit(int value);

	public void set_hitInfo(Object value);

	public int get_subHit();

	public Object get_hitInfo();
}
