package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.capabilities;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

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

	private static Map<String, Compat_Capability<?>> capabilities = new HashMap<>();

	public static Compat_Capability<?> getCapability(String name) {
		Compat_Capability<?> ret = capabilities.get(name);
		return ret;
	}

	public <T> void Compat_register(Class<T> type, Compat_Capability_IStorage<T> storage, Callable<? extends T> impl) {
		Compat_Capability<T> capabiltiy = new Compat_Capability<T>(type.getName(), storage, impl);
		capabilities.put(type.getName(), capabiltiy);
	}

	public <T> void Compat_register(Class<T> type, Compat_Capability_IStorage<T> storage, Class<T> impl) {
		Callable<? extends T> factory = () -> impl.newInstance();

		Compat_register(type, storage, factory);
	}
}
