package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.event;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
public class Compat_FMLPreInitializationEvent {

	private final FMLPreInitializationEvent original;

	public Compat_FMLPreInitializationEvent(FMLPreInitializationEvent original) {
		this.original = original;
	}

	public FMLPreInitializationEvent getReal() {
		return original;
	}
}