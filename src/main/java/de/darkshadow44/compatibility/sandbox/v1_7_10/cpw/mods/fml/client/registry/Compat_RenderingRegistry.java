package de.darkshadow44.compatibility.sandbox.v1_7_10.cpw.mods.fml.client.registry;

public class Compat_RenderingRegistry {
	static int dummy = 0;

	public static int Compat_getNextAvailableRenderId() {
		return dummy++; // TODO
	}
}
