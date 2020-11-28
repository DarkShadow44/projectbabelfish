package compat.sandbox.net.minecraftforge.fml.client.registry;

import java.util.HashMap;
import java.util.Map;

import compat.sandbox.cpw.mods.fml.client.registry.Compat_ISimpleBlockRenderingHandler;

public class Compat_RenderingRegistry {
	static int nextId = 1;

	private static final Map<Integer, Compat_ISimpleBlockRenderingHandler> renderers = new HashMap<>();

	public static int Compat_getNextAvailableRenderId() {
		return nextId++;
	}

	public static void Compat_registerBlockHandler(int id, Compat_ISimpleBlockRenderingHandler handler) {
		renderers.put(id, handler);
	}
}
