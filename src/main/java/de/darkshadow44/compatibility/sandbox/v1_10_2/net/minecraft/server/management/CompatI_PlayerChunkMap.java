package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.server.management;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.management.PlayerChunkMap;

public interface CompatI_PlayerChunkMap {
	public PlayerChunkMap get();

	public boolean isPlayerWatchingChunkSuper(EntityPlayerMP player, int p1, int p2);
}
