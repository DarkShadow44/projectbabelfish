package compat.sandbox.net.minecraft.server.management;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.entity.player.Compat_EntityPlayerMP;
import net.minecraft.server.management.PlayerChunkMap;

public class Compat_PlayerChunkMap {
	private CompatI_PlayerChunkMap wrapper;

	// When called from Mod
	public Compat_PlayerChunkMap() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_PlayerChunkMap.class, this));
	}

	// When called from child
	protected Compat_PlayerChunkMap(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_PlayerChunkMap(PlayerChunkMap original) {
		this.initialize(Factory.createWrapper(CompatI_PlayerChunkMap.class, original));
	}

	protected void initialize(CompatI_PlayerChunkMap wrapper) {
		this.wrapper = wrapper;
	}

	public PlayerChunkMap getReal() {
		return wrapper.get();
	}

	public boolean Compat_func_72694_a(Compat_EntityPlayerMP player, int p1, int p2) {
		return wrapper.isPlayerWatchingChunkSuper(player.getReal(), p1, p2);
	}
}
