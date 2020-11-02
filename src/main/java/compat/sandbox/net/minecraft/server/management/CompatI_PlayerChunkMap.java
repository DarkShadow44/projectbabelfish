package compat.sandbox.net.minecraft.server.management;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.management.PlayerChunkMap;

public interface CompatI_PlayerChunkMap {
	public PlayerChunkMap get();

	public boolean isPlayerWatchingChunkSuper(EntityPlayerMP player, int p1, int p2);
}
