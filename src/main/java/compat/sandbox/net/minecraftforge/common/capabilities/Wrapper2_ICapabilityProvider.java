package compat.sandbox.net.minecraftforge.common.capabilities;

import compat.sandbox.net.minecraft.util.Compat_EnumFacing;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class Wrapper2_ICapabilityProvider implements ICapabilityProvider {

	private final Compat_ICapabilityProvider fake;

	public Wrapper2_ICapabilityProvider(Compat_ICapabilityProvider fake) {
		this.fake = fake;
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return fake.Compat_hasCapability(Compat_Capability.getFake(capability), Compat_EnumFacing.map_real_to_fake(facing));
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return (T) fake.Compat_getCapability(Compat_Capability.getFake(capability), Compat_EnumFacing.map_real_to_fake(facing));
	}

}
