package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.world;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.world.World;

public class Compat_World {
	private CompatI_World wrapper;

	// When called from Mod
	public Compat_World() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_World.class, this));
	}

	// When called from child
	protected Compat_World(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_World(World original) {
		this.initialize(Factory.createWrapper(CompatI_World.class, original));
	}

	protected void initialize(CompatI_World wrapper) {
		this.wrapper = wrapper;
	}

	public World getReal() {
		return wrapper.get();
	}
}
