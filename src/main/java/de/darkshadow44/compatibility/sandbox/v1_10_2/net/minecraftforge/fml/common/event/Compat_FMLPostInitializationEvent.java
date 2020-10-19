package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.event;

import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

public class Compat_FMLPostInitializationEvent {

	private final FMLPostInitializationEvent original;

	public Compat_FMLPostInitializationEvent(FMLPostInitializationEvent original) {
		this.original = original;
	}

	public FMLPostInitializationEvent getReal() {
		return original;
	}
}
