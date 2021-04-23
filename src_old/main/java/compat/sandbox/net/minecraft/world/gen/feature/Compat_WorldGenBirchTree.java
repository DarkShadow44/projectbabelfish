package compat.sandbox.net.minecraft.world.gen.feature;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.world.gen.feature.WorldGenBirchTree;

public class Compat_WorldGenBirchTree extends Compat_WorldGenAbstractTree {
	private CompatI_WorldGenBirchTree wrapper;

	// When called from Mod
	public Compat_WorldGenBirchTree() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_WorldGenBirchTree.class, this));
	}

	// When called from child
	protected Compat_WorldGenBirchTree(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_WorldGenBirchTree(WorldGenBirchTree original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_WorldGenBirchTree.class, original));
	}

	protected void initialize(CompatI_WorldGenBirchTree wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public WorldGenBirchTree getReal() {
		return wrapper.get();
	}
}
