package compat.sandbox.net.minecraft.util.math;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;

public interface CompatI_BlockPos extends CompatI_Vec3i {
	public BlockPos get();

	public BlockPos offsetSuper(EnumFacing facing);

	public BlockPos addSuper(Vec3i vec);

	public double distanceSqSuper(Vec3i vec);

	public Compat_BlockPos getFake();

	public long toLongSuper();

	public BlockPos subtractSuper(Vec3i vec);

	public BlockPos downSuper();

	public BlockPos upSuper();

	public BlockPos addSuper(int x, int y, int z);
}
