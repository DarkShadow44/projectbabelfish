package de.darkshadow44.compatibility.sandbox.v1_10_2.cpw.mods.fml.common.event;

import java.io.File;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.relauncher.Compat_Side;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Compat_FMLPreInitializationEvent {

	private final FMLPreInitializationEvent original;

	public Compat_FMLPreInitializationEvent(FMLPreInitializationEvent original) {
		this.original = original;
	}

	public File Compat_getModConfigurationDirectory() {
		return new File(original.getModConfigurationDirectory(), "1.7.10");
	}

	public Compat_Side Compat_getSide() {
		return Compat_Side.fromReal(original.getSide());
	}
}
