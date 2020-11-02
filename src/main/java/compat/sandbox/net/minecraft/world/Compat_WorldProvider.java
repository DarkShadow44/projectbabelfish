package compat.sandbox.net.minecraft.world;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
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
