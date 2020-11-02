package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world.gen.feature;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
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
