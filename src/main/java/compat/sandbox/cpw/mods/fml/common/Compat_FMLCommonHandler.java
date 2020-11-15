package compat.sandbox.cpw.mods.fml.common;

import compat.sandbox.cpw.mods.fml.common.eventhandler.Compat_EventBus;
import compat.sandbox.net.minecraftforge.fml.relauncher.Compat_Side;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class Compat_FMLCommonHandler {

	private final FMLCommonHandler original;

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