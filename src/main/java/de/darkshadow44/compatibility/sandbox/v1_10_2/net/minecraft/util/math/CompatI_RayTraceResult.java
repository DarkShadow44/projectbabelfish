package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.RayTraceResult.Type;

public interface CompatI_RayTraceResult {
	public RayTraceResult get();

	public Type get_typeOfHit();

	public BlockPos getBlockPosSuper();
}
