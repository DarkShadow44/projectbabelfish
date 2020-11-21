package compat.sandbox.net.minecraftforge.common.property;

import java.util.Optional;

import com.google.common.collect.ImmutableMap;

import compat.sandbox.net.minecraft.block.state.Compat_IBlockState;

public interface Compat_IExtendedBlockState extends Compat_IBlockState {
	public Compat_IExtendedBlockState Compat_withProperty(Compat_IUnlistedProperty<?> property, Object obj);

	public ImmutableMap<Compat_IUnlistedProperty<?>, Optional<?>> Compat_getUnlistedProperties();

	public Object Compat_getValue(Compat_IUnlistedProperty<?> property);
}
