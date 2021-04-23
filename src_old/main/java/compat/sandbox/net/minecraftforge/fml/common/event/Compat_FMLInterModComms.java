package compat.sandbox.net.minecraftforge.fml.common.event;

import net.minecraftforge.fml.common.event.FMLInterModComms;

public class Compat_FMLInterModComms {
	private final FMLInterModComms original;

	public Compat_FMLInterModComms(FMLInterModComms original) {
		this.original = original;
	}

	public FMLInterModComms getReal() {
		return original;
	}
}
