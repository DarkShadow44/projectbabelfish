package compat.sandbox.net.minecraft.util.math;

import net.minecraft.util.math.BlockPos.MutableBlockPos;

public interface CompatI_BlockPos_MutableBlockPos extends CompatI_BlockPos {
	public MutableBlockPos get();

	public MutableBlockPos setPosSuper(int p1, int p2, int p3);

	public Compat_BlockPos_MutableBlockPos getFake();
}
