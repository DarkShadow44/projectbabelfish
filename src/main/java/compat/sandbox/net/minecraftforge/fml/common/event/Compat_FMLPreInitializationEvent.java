package compat.sandbox.net.minecraftforge.fml.common.event;

import java.io.File;

import org.apache.logging.log4j.Logger;

import compat.core.CompatibilityMod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Compat_FMLPreInitializationEvent {

	private final FMLPreInitializationEvent original;

	public Compat_FMLPreInitializationEvent(FMLPreInitializationEvent original) {
		this.original = original;
	}

	public FMLPreInitializationEvent getReal() {
		return original;
	}

	public Logger Compat_getModLog() {
		return original.getModLog();
	}

	public File Compat_getSuggestedConfigurationFile() {
		File parent = original.getSuggestedConfigurationFile().getParentFile();
		File folder = new File(parent, "1.10.2"); // TODO set to current layer!
		return new File(folder, CompatibilityMod.LAYER_1_10_2.currentModId);
	}
}
