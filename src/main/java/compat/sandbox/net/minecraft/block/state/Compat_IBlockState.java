package compat.sandbox.net.minecraft.block.state;

import com.google.common.collect.ImmutableMap;

import compat.sandbox.net.minecraft.block.Compat_Block;
import compat.sandbox.net.minecraft.block.material.Compat_Material;
import compat.sandbox.net.minecraft.block.properties.Compat_IProperty;
import compat.sandbox.net.minecraft.util.Compat_EnumFacing;
import compat.sandbox.net.minecraft.util.math.Compat_AxisAlignedBB;
import compat.sandbox.net.minecraft.util.math.Compat_BlockPos;
import compat.sandbox.net.minecraft.world.Compat_IBlockAccess;
import compat.sandbox.net.minecraft.world.Compat_World;
import net.minecraft.block.state.IBlockState;

public interface Compat_IBlockState {
	<T extends Comparable<T>, V extends T> Compat_IBlockState Compat_func_177226_a(Compat_IProperty<T> var1, V var2);

	public IBlockState getReal();

	Comparable<?> Compat_func_177229_b(Compat_IProperty<?> property);

	public boolean Compat_isSideSolid(Compat_IBlockAccess world, Compat_BlockPos pos, Compat_EnumFacing facing);

	public Compat_Block Compat_func_177230_c();

	ImmutableMap<Compat_IProperty<?>, Comparable<?>> Compat_func_177228_b();

	Compat_Material Compat_func_185904_a();

	Compat_AxisAlignedBB Compat_func_185918_c(Compat_World world, Compat_BlockPos pos);

	public static Compat_IBlockState getFake(IBlockState state) {
		//if (state instanceof IExtendedBlockState) {
		//	return new Wrapper_IExtendedBlockState((IExtendedBlockState) state);
		//}
		return new Wrapper_IBlockState(state);
	}
}
