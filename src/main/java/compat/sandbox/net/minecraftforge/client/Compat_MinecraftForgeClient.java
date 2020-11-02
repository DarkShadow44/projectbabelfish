package compat.sandbox.net.minecraftforge.client;

import compat.sandbox.net.minecraft.util.Compat_BlockRenderLayer;
import net.minecraftforge.client.MinecraftForgeClient;

public class Compat_MinecraftForgeClient {

	public static int Compat_getRenderPass() {
		return MinecraftForgeClient.getRenderPass();
	}

	public static Compat_BlockRenderLayer Compat_getRenderLayer() {
		return Compat_BlockRenderLayer.getFake(MinecraftForgeClient.getRenderLayer());
	}
}
