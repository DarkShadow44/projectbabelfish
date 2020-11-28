package compat.sandbox.net.minecraft.world;

import compat.sandbox.net.minecraft.block.state.Compat_IBlockState;
import compat.sandbox.net.minecraft.tileentity.Compat_TileEntity;
import compat.sandbox.net.minecraft.util.math.Compat_BlockPos;
import net.minecraft.world.IBlockAccess;

public interface Compat_IBlockAccess {
	public IBlockAccess getReal();

	public Compat_TileEntity Compat_func_175625_s(Compat_BlockPos pos);

	public Compat_IBlockState Compat_func_180495_p(Compat_BlockPos pos);

	public static Compat_IBlockAccess getFake(IBlockAccess world) {
		return new Wrapper_IBlockAccess(world);
	}

	public int Compat_func_72805_g(int x, int y, int z);

	public Compat_TileEntity Compat_func_147438_o(int x, int y, int z);
}
