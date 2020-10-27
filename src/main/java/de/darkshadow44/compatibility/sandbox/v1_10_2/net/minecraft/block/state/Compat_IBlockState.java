package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state;

import com.google.common.collect.ImmutableMap;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.Compat_Block;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.properties.Compat_IProperty;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_EnumFacing;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math.Compat_BlockPos;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world.Compat_IBlockAccess;
import net.minecraft.block.state.IBlockState;

public interface Compat_IBlockState {
	<T extends Comparable<T>, V extends T> Compat_IBlockState Compat_func_177226_a(Compat_IProperty<T> var1, V var2);

	public IBlockState getReal();

	Comparable<?> Compat_func_177229_b(Compat_IProperty<?> property);

	public boolean Compat_isSideSolid(Compat_IBlockAccess world, Compat_BlockPos pos, Compat_EnumFacing facing);

	public Compat_Block Compat_func_177230_c();

	ImmutableMap<Compat_IProperty<?>, Comparable<?>> Compat_func_177228_b();
}
