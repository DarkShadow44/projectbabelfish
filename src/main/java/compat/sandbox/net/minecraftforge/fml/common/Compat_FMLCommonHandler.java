package compat.sandbox.net.minecraftforge.fml.common;

import net.minecraftforge.fml.common.FMLCommonHandler;

public class Compat_FMLCommonHandler {

	private final FMLCommonHandler original;

	public Compat_FMLCommonHandler(FMLCommonHandler original) {
		this.original = original;
	}

	public FMLCommonHandler getReal() {
		return original;
	}

	public static Compat_FMLCommonHandler Compat_instance() {
		return new Compat_FMLCommonHandler(FMLCommonHandler.instance());
	}

	public void Compat_exitJava(int exitCode, boolean hardExit) {
		original.exitJava(exitCode, hardExit);
	}
}
