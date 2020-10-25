package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.server.management;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
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
}
