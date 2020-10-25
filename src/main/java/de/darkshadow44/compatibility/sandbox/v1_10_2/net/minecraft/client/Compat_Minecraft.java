package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client;

import com.google.common.util.concurrent.ListenableFuture;

import net.minecraft.client.Minecraft;

public class Compat_Minecraft {

	private final Minecraft original;

	public Compat_Minecraft(Minecraft original) {
		this.original = original;
	}

	public Minecraft getReal() {
		return original;
	}

	public static Compat_Minecraft Compat_func_71410_x() {
		return new Compat_Minecraft(Minecraft.getMinecraft());
	}

	public ListenableFuture<Object> Compat_func_152344_a(Runnable run) {
		return original.addScheduledTask(run);
	}
}
