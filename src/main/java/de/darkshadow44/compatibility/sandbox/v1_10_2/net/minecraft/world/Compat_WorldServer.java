package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.server.management.Compat_PlayerChunkMap;
import net.minecraft.world.WorldServer;

public class Compat_WorldServer extends Compat_World {
	private WorldServer original;
	private CompatI_WorldServer thisReal;

	// When called from Mod
	public Compat_WorldServer() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_WorldServer.class, this), null);
	}

	// When called from child
	protected Compat_WorldServer(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_WorldServer(WorldServer original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_WorldServer thisReal, WorldServer original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public WorldServer getReal() {
		return original == null ? thisReal.get() : original;
	}

	public Compat_PlayerChunkMap Compat_func_184164_w() {
		if (original == null)
			return new Compat_PlayerChunkMap(thisReal.getPlayerChunkMapSuper());
		else
			return new Compat_PlayerChunkMap(original.getPlayerChunkMap());
	}
}
