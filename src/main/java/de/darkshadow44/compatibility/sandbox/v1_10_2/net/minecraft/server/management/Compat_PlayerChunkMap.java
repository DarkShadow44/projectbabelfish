package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.server.management;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.player.Compat_EntityPlayerMP;
import net.minecraft.server.management.PlayerChunkMap;

public class Compat_PlayerChunkMap {
	private PlayerChunkMap original;
	private CompatI_PlayerChunkMap thisReal;

	// When called from Mod
	public Compat_PlayerChunkMap() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_PlayerChunkMap.class, this), null);
	}

	// When called from child
	protected Compat_PlayerChunkMap(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_PlayerChunkMap(PlayerChunkMap original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_PlayerChunkMap thisReal, PlayerChunkMap original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public PlayerChunkMap getReal() {
		return original == null ? thisReal.get() : original;
	}

	public boolean Compat_func_72694_a(Compat_EntityPlayerMP player, int p1, int p2) {
		if (original == null)
			return thisReal.isPlayerWatchingChunkSuper(player.getReal(), p1, p2);
		else
			return original.isPlayerWatchingChunk(player.getReal(), p1, p2);
	}
}
