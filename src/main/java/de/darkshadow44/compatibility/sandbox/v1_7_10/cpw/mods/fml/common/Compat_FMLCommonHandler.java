package de.darkshadow44.compatibility.sandbox.v1_7_10.cpw.mods.fml.common;

import de.darkshadow44.compatibility.sandbox.v1_7_10.cpw.mods.fml.common.eventhandler.Compat_EventBus;
import de.darkshadow44.compatibility.sandbox.v1_7_10.cpw.mods.fml.relauncher.Compat_Side;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class Compat_FMLCommonHandler {

	private FMLCommonHandler original;

	public Compat_FMLCommonHandler(FMLCommonHandler original) {
		this.original = original;
	}

	public static Compat_FMLCommonHandler Compat_instance() {
		return new Compat_FMLCommonHandler(FMLCommonHandler.instance());
	}

	public Compat_Side Compat_getEffectiveSide() {
		return Compat_Side.fromReal(original.getEffectiveSide());
	}

	public Compat_EventBus Compat_bus() {
		return new Compat_EventBus();
	}
}
