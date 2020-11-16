package compat.sandbox.net.minecraft.network;

import net.minecraft.network.NetHandlerPlayServer;

public class Compat_NetHandlerPlayServer {

	@SuppressWarnings("unused")
	private final NetHandlerPlayServer original;

	public Compat_NetHandlerPlayServer(NetHandlerPlayServer original) {
		this.original = original;
	}
}
