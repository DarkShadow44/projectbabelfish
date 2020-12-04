package compat.sandbox.net.minecraft.world;

import compat.sandbox.net.minecraft.block.Compat_Block;
import compat.sandbox.net.minecraft.block.state.Compat_IBlockState;
import compat.sandbox.net.minecraft.block.state.Wrapper_IBlockState;
import compat.sandbox.net.minecraft.tileentity.Compat_TileEntity;
import compat.sandbox.net.minecraft.util.math.Compat_BlockPos;
import compat.sandbox.net.minecraft.world.biome.Compat_Biome;
import compat.sandbox.net.minecraftforge.common.util.Compat_ForgeDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.Biome;

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

		return Compat_TileEntity.getFake(tile);
	}

	public Compat_IBlockState Compat_func_180495_p(Compat_BlockPos pos) {
		IBlockState state = original.getBlockState(pos.getReal());

		return new Wrapper_IBlockState(state);
	}

	private int getBlockMeta(BlockPos pos) {
		IBlockState state = original.getBlockState(pos);
		return state.getBlock().getMetaFromState(state);
	}

	public int Compat_func_72805_g(int x, int y, int z) {
		return getBlockMeta(new BlockPos(x, y, z));
	}

	@Override
	public Compat_TileEntity Compat_func_147438_o(int x, int y, int z) {
		TileEntity result = original.getTileEntity(new BlockPos(x, y, z));
		return Compat_TileEntity.getFake(result);
	}

	public Compat_Block Compat_func_147439_a(int x, int y, int z) {
		return Compat_Block.getFake(original.getBlockState(new BlockPos(x, y, z)).getBlock());
	}

	@Override
	public boolean Compat_func_147437_c(int x, int y, int z) {
		return original.isAirBlock(new BlockPos(x, y, z));
	}

	@Override
	public int Compat_func_72800_K() {
		return 256; // TODO
	}

	@Override
	public Compat_Biome Compat_func_72807_a(int x, int z) {
		Biome result = original.getBiome(new BlockPos(x, 0, z));
		return Compat_Biome.getFake(result);
	}

	@Override
	public boolean Compat_isSideSolid(int x, int y, int z, Compat_ForgeDirection direction, boolean p1) {
		EnumFacing side = Compat_ForgeDirection.getReal(direction);
		return original.isSideSolid(new BlockPos(x, y, z), side, p1);
	}
}
