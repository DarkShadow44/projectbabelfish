package compat.sandbox.net.minecraft.world.gen.feature;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.world.gen.feature.WorldGenSwamp;

public class Compat_WorldGenSwamp extends Compat_WorldGenAbstractTree {
	private CompatI_WorldGenSwamp wrapper;

	// When called from Mod
	public Compat_WorldGenSwamp() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_WorldGenSwamp.class, this));
	}

	// When called from child
	protected Compat_WorldGenSwamp(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_WorldGenSwamp(WorldGenSwamp original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_WorldGenSwamp.class, original));
	}

	protected void initialize(CompatI_WorldGenSwamp wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public WorldGenSwamp getReal() {
		return wrapper.get();
	}
}
