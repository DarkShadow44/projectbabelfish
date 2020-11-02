package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;

public interface CompatI_BlockPos extends CompatI_Vec3i {
	public BlockPos get();

	public BlockPos offsetSuper(EnumFacing facing);

	public BlockPos addSuper(Vec3i vec);

	public double distanceSqSuper(Vec3i vec);
}
