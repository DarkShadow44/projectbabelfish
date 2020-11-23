package compat.sandbox.net.minecraftforge.fml.client.registry;

public class Compat_RenderingRegistry {
	static int dummy = 0;

	public static int Compat_getNextAvailableRenderId() {
		return dummy++; // TODO
	}
}
