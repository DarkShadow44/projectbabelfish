package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.world;

import net.minecraft.profiler.Profiler;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.WorldInfo;

public class Compat_WorldServer extends WorldServer {

	public Compat_WorldServer(MinecraftServer server, ISaveHandler saveHandlerIn, WorldInfo info, int dimensionId, Profiler profilerIn) {
		super(server, saveHandlerIn, info, dimensionId, profilerIn);
	}

}
