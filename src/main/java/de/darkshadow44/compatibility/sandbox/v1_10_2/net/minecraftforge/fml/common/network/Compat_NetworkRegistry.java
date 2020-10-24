package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.network;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.network.simpleimpl.Compat_SimpleNetworkWrapper;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class Compat_NetworkRegistry {

	private final NetworkRegistry original;

	public Compat_NetworkRegistry(NetworkRegistry original) {
		this.original = original;
	}

	public NetworkRegistry getReal() {
		return original;
	}

	public static Compat_NetworkRegistry Compat_get_INSTANCE() {
		return new Compat_NetworkRegistry(NetworkRegistry.INSTANCE);
	}

	public Compat_SimpleNetworkWrapper Compat_newSimpleChannel(String name) {
		return new Compat_SimpleNetworkWrapper(original.newSimpleChannel(name));
	}
}
