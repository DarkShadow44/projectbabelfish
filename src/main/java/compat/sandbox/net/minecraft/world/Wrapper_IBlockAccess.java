package compat.sandbox.net.minecraft.world;

import compat.sandbox.net.minecraft.block.state.Compat_IBlockState;
import compat.sandbox.net.minecraft.block.state.Wrapper_IBlockState;
import compat.sandbox.net.minecraft.tileentity.Compat_TileEntity;
import compat.sandbox.net.minecraft.util.math.Compat_BlockPos;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;

public class Wrapper_IBlockAccess implements Compat_IBlockAccess {

	private final IBlockAccess original;

	public Wrapper_IBlockAccess(IBlockAccess original) {
		this.original = original;
	}

	public IBlockAccess getReal() {
		return original;
	}

	@Override
	public Compat_TileEntity Compat_func_175625_s(Compat_BlockPos pos) {
		TileEntity tile = original.getTileEntity(pos.getReal());

		if (tile == null)
			return null;

		return Compat_TileEntity.get_fake(tile);
	}

	public Compat_IBlockState Compat_func_180495_p(Compat_BlockPos pos) {
		IBlockState state = original.getBlockState(pos.getReal());

		return new Wrapper_IBlockState(state);
	}
}
