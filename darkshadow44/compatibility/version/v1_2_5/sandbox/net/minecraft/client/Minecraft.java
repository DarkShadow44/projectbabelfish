package darkshadow44.compatibility.version.v1_2_5.sandbox.net.minecraft.client;

import java.io.File;

import darkshadow44.compatibility.version.v1_2_5.shim.net.minecraft.client.MinecraftShim;

public class Minecraft {

	public static File getMinecraftDir() {
		return new File(MinecraftShim.getMinecraftDir(), "compatibility/1.2.5");
	}
}
