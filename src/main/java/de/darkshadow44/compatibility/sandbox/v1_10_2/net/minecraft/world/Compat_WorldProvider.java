package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.world.WorldProvider;

public class Compat_WorldProvider {
	private CompatI_WorldProvider wrapper;

	// When called from Mod
	public Compat_WorldProvider() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_WorldProvider.class, this));
	}

	// When called from child
	protected Compat_WorldProvider(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_WorldProvider(WorldProvider original) {
		this.initialize(Factory.createWrapper(CompatI_WorldProvider.class, original));
	}

	protected void initialize(CompatI_WorldProvider wrapper) {
		this.wrapper = wrapper;
	}

	public WorldProvider getReal() {
		return wrapper.get();
	}
}
