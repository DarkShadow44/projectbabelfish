package compat.sandbox.net.minecraft.world;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.server.management.Compat_PlayerChunkMap;
import net.minecraft.world.WorldServer;

public class Compat_WorldServer extends Compat_World {
	private CompatI_WorldServer wrapper;

	// When called from Mod
	public Compat_WorldServer() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_WorldServer.class, this));
	}

	// When called from child
	protected Compat_WorldServer(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_WorldServer(WorldServer original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_WorldServer.class, original));
	}

	protected void initialize(CompatI_WorldServer wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public WorldServer getReal() {
		return wrapper.get();
	}

	public Compat_PlayerChunkMap Compat_func_184164_w() {
		return new Compat_PlayerChunkMap(wrapper.getPlayerChunkMapSuper());
	}
}
