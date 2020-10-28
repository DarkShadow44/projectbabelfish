package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.property;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state.Wrapper_IBlockState;
import net.minecraftforge.common.property.IExtendedBlockState;

public class Wrapper_IExtendedBlockState extends Wrapper_IBlockState implements Compat_IExtendedBlockState {

	private final IExtendedBlockState original;

	public Wrapper_IExtendedBlockState(IExtendedBlockState original) {
		super(original);
		this.original = original;
	}

	public IExtendedBlockState getReal() {
		return original;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Compat_IExtendedBlockState Compat_withProperty(Compat_IUnlistedProperty<?> property, Object obj) {
		return new Wrapper_IExtendedBlockState(original.withProperty(new Wrapper_IUnlistedProperty(property), obj));
	}
}
