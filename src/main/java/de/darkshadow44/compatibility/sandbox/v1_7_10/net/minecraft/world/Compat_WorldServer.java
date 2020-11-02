package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.world;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
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
		this.wrapper = wrapper;
	}

	public WorldServer getReal() {
		return wrapper.get();
	}
}
