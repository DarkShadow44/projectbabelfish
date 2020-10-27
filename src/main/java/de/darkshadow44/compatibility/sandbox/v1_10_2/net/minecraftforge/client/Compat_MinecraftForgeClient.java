package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.client;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_BlockRenderLayer;
import net.minecraftforge.client.MinecraftForgeClient;

public class Compat_MinecraftForgeClient {

	public static int Compat_getRenderPass() {
		return MinecraftForgeClient.getRenderPass();
	}

	public static Compat_BlockRenderLayer Compat_getRenderLayer() {
		return Compat_BlockRenderLayer.getFake(MinecraftForgeClient.getRenderLayer());
	}
}
