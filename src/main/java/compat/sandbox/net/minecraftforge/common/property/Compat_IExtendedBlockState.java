package compat.sandbox.net.minecraftforge.common.property;

import java.util.Optional;

import com.google.common.collect.ImmutableMap;

public interface Compat_IExtendedBlockState {
	public Compat_IExtendedBlockState Compat_withProperty(Compat_IUnlistedProperty<?> property, Object obj);

	public ImmutableMap<Compat_IUnlistedProperty<?>, Optional<?>> Compat_getUnlistedProperties();

	public Object Compat_getValue(Compat_IUnlistedProperty<?> property);
}
