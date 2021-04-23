package compat.sandbox.net.minecraft.world.gen.feature;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.world.gen.feature.WorldGenTaiga1;

public class Compat_WorldGenTaiga1 extends Compat_WorldGenAbstractTree {
	private CompatI_WorldGenTaiga1 wrapper;

	// When called from Mod
	public Compat_WorldGenTaiga1() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_WorldGenTaiga1.class, this));
	}

	// When called from child
	protected Compat_WorldGenTaiga1(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_WorldGenTaiga1(WorldGenTaiga1 original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_WorldGenTaiga1.class, original));
	}

	protected void initialize(CompatI_WorldGenTaiga1 wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public WorldGenTaiga1 getReal() {
		return wrapper.get();
	}
}
