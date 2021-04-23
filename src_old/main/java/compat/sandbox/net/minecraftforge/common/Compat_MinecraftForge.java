package compat.sandbox.net.minecraftforge.common;

import compat.sandbox.net.minecraftforge.fml.common.eventhandler.Compat_EventBus;
import net.minecraftforge.common.MinecraftForge;

public class Compat_MinecraftForge {
	private final MinecraftForge original;

	public Compat_MinecraftForge(MinecraftForge original) {
		this.original = original;
	}

	public MinecraftForge getReal() {
		return original;
	}

	public static Compat_EventBus Compat_get_EVENT_BUS() {
		return new Compat_EventBus(MinecraftForge.EVENT_BUS);
	}
}
