package darkshadow44.compatibility.version.v1_2_5.shim.net.minecraft.client;

import java.io.File;

import net.minecraft.client.Minecraft;

public class MinecraftShim {

	public static File getMinecraftDir() {
		return Minecraft.getMinecraft().mcDataDir;
	}
}
