package compat.sandbox.net.minecraft.server;

import net.minecraft.server.MinecraftServer;

public class Compat_MinecraftServer {

	@SuppressWarnings("unused")
	private final MinecraftServer original;

	public Compat_MinecraftServer(MinecraftServer original) {
		this.original = original;
	}

}
