package de.darkshadow44.compatibility.sandbox.v1_7_10.cpw.mods.fml.common.event;

import java.io.File;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Compat_FMLPreInitializationEvent {

	private FMLPreInitializationEvent original;

	public Compat_FMLPreInitializationEvent(FMLPreInitializationEvent original) {
		this.original = original;
	}

	public File Compat_getModConfigurationDirectory() {
		return new File(original.getModConfigurationDirectory(), "1.7.10");
	}
}
