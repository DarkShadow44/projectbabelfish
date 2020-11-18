package compat.sandbox.net.minecraft.server;

import com.google.common.util.concurrent.ListenableFuture;

import net.minecraft.server.MinecraftServer;

public class Compat_MinecraftServer {

	private final MinecraftServer original;

	public Compat_MinecraftServer(MinecraftServer original) {
		this.original = original;
	}

	public MinecraftServer getReal() {
		return original;
	}

	public ListenableFuture<Object> Compat_func_152344_a(Runnable run) {
		return original.addScheduledTask(run);
	}

	public static Compat_MinecraftServer getFake(MinecraftServer server) {
		return new Compat_MinecraftServer(server);
	}

}
