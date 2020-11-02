package compat.sandbox.cpw.mods.fml.common.network.simpleimpl;

import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class Compat_SimpleNetworkWrapper {
	@SuppressWarnings("unused")
	private final SimpleNetworkWrapper original;

	public Compat_SimpleNetworkWrapper(SimpleNetworkWrapper original) {
		this.original = original;
	}
}
