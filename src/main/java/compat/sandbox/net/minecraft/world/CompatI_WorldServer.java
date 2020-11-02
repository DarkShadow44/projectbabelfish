package compat.sandbox.net.minecraft.world;

import net.minecraft.server.management.PlayerChunkMap;
import net.minecraft.world.WorldServer;

public interface CompatI_WorldServer extends CompatI_World {
	public WorldServer get();

	public PlayerChunkMap getPlayerChunkMapSuper();
}
