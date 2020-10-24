package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.tileentity.Compat_TileEntity;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math.Compat_BlockPos;
import net.minecraft.world.IBlockAccess;

public interface Compat_IBlockAccess {
	public IBlockAccess getReal();

	public Compat_TileEntity Compat_func_175625_s(Compat_BlockPos pos);
}
