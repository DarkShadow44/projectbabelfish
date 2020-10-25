package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.client;

import net.minecraftforge.client.MinecraftForgeClient;

public class Compat_MinecraftForgeClient {

	public static int Compat_getRenderPass() {
		return MinecraftForgeClient.getRenderPass();
	}
}
