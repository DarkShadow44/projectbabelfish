package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.property;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import com.google.common.collect.ImmutableMap;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state.Wrapper_IBlockState;
import net.minecraftforge.common.property.IExtendedBlockState;
import net.minecraftforge.common.property.IUnlistedProperty;

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

	@Override
	public ImmutableMap<Compat_IUnlistedProperty<?>, Optional<?>> Compat_getUnlistedProperties() {
		Map<Compat_IUnlistedProperty<?>, Optional<?>> ret = new HashMap<>();
		for (Entry<IUnlistedProperty<?>, Optional<?>> entry : original.getUnlistedProperties().entrySet()) {
			IUnlistedProperty<?> property = entry.getKey();
			Optional<?> value = entry.getValue();
			ret.put(Compat_IUnlistedProperty.getFake(property), value);
		}
		return ImmutableMap.copyOf(ret);
	}
}
