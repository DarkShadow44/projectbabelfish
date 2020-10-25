package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math;

import net.minecraft.util.math.BlockPos.MutableBlockPos;

public interface CompatI_BlockPos_MutableBlockPos extends CompatI_BlockPos {
	public MutableBlockPos get();

	public MutableBlockPos setPosSuper(int p1, int p2, int p3);
}
