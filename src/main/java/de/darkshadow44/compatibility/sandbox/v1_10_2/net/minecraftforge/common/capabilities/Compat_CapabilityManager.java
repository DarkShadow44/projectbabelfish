package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.capabilities;

import net.minecraftforge.common.capabilities.CapabilityManager;

public class Compat_CapabilityManager {

	private final CapabilityManager original;

	public Compat_CapabilityManager(CapabilityManager original) {
		this.original = original;
	}

	public CapabilityManager getReal() {
		return original;
	}

	public static Compat_CapabilityManager Compat_get_INSTANCE() {
		return new Compat_CapabilityManager(CapabilityManager.INSTANCE);
	}

	@SuppressWarnings({ "deprecation" })
	public <T> void Compat_register(Class<T> type, Compat_Capability_IStorage storage, Class<T> impl) {
		original.register(type, new Wrapper_Capability_IStorage<T>(storage), impl); // TODO classes?
	}
}
