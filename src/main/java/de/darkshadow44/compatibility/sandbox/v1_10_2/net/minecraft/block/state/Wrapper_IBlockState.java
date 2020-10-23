package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.properties.Compat_IProperty;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_EnumFacing;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;

public class Wrapper_IBlockState implements Compat_IBlockState {

	private final IBlockState original;

	public Wrapper_IBlockState(IBlockState original) {
		this.original = original;
	}

	public IBlockState getReal() {
		return original;
	}

	@Override
	public <T extends Comparable<T>, V extends T> Compat_IBlockState Compat_func_177226_a(Compat_IProperty<T> var1, V var2) {
		return new Wrapper_IBlockState(original.withProperty(var1.getReal(), var2));
	}

	@Override
	public Comparable<?> Compat_func_177229_b(Compat_IProperty<?> property) {
		Comparable<?> value = original.getValue(property.getReal());
		if (value instanceof EnumFacing) {
			return Compat_EnumFacing.map_real_to_fake((EnumFacing) value);
		}
		return value;
	}
}
