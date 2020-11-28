package compat.sandbox.net.minecraftforge.fml.common.network;

import compat.sandbox.net.minecraftforge.fml.common.network.simpleimpl.Compat_SimpleNetworkWrapper;
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

	public void Compat_registerGuiHandler(Object obj, Compat_IGuiHandler handler) {
		// TODO
	}
}
