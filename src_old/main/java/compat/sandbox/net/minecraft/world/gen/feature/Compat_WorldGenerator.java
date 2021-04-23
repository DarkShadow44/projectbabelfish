package compat.sandbox.net.minecraft.world.gen.feature;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.world.gen.feature.WorldGenerator;

public class Compat_WorldGenerator {
	private CompatI_WorldGenerator wrapper;

	// When called from Mod
	public Compat_WorldGenerator() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_WorldGenerator.class, this));
	}

	// When called from child
	protected Compat_WorldGenerator(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_WorldGenerator(WorldGenerator original) {
		this.initialize(Factory.createWrapper(CompatI_WorldGenerator.class, original));
	}

	protected void initialize(CompatI_WorldGenerator wrapper) {
		this.wrapper = wrapper;
	}

	public WorldGenerator getReal() {
		return wrapper.get();
	}
}
