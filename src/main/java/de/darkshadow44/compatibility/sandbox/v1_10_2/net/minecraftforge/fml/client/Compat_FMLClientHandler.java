package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.client;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.entity.Compat_EntityPlayerSP;
import net.minecraftforge.fml.client.FMLClientHandler;

public class Compat_FMLClientHandler {

	private final FMLClientHandler original;

	public Compat_FMLClientHandler(FMLClientHandler original) {
		this.original = original;
	}

	public FMLClientHandler getReal() {
		return original;
	}

	public static Compat_FMLClientHandler Compat_instance() {
		return new Compat_FMLClientHandler(FMLClientHandler.instance());
	}

	public Compat_EntityPlayerSP Compat_getClientPlayerEntity() {
		return new Compat_EntityPlayerSP(original.getClientPlayerEntity());
	}
}
