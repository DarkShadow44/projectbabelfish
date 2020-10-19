package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.properties.Compat_IProperty;

public interface Compat_IBlockState {
	<T extends Comparable<T>, V extends T> Compat_IBlockState Compat_func_177226_a(Compat_IProperty<T> var1, V var2);
}
