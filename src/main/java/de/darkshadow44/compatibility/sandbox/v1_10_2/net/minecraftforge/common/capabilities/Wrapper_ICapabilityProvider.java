package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.capabilities;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_EnumFacing;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class Wrapper_ICapabilityProvider implements Compat_ICapabilityProvider {

	private final ICapabilityProvider real;

	public Wrapper_ICapabilityProvider(ICapabilityProvider real) {
		this.real = real;
	}

	public ICapabilityProvider getReal() {
		return real;
	}

	@Override
	public boolean Compat_hasCapability(Compat_Capability<?> capability, Compat_EnumFacing facing) {
		return real.hasCapability(capability.getReal(), facing.getReal());
	}

	@Override
	public Object Compat_getCapability(Compat_Capability<?> capability, Compat_EnumFacing facing) {
		return real.getCapability(capability.getReal(), facing.getReal());
	}
}
