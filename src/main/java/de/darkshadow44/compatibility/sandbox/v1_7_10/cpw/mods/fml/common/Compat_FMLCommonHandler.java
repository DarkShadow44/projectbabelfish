package de.darkshadow44.compatibility.sandbox.v1_7_10.cpw.mods.fml.common;

import net.minecraftforge.fml.common.FMLCommonHandler;

public class Compat_FMLCommonHandler {

	@SuppressWarnings("unused")
	private FMLCommonHandler original;

	public Compat_FMLCommonHandler(FMLCommonHandler original) {
		this.original = original;
	}

	public static Compat_FMLCommonHandler Compat_instance() {
		return new Compat_FMLCommonHandler(FMLCommonHandler.instance());
	}
}
