package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.capabilities;

import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class Wrapper_ICapabilityProvider implements Compat_ICapabilityProvider {

	private final ICapabilityProvider original;

	public Wrapper_ICapabilityProvider(ICapabilityProvider original) {
		this.original = original;
	}

	public ICapabilityProvider getReal() {
		return original;
	}
}
