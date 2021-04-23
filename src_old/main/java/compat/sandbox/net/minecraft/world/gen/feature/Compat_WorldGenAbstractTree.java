package compat.sandbox.net.minecraft.world.gen.feature;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class Compat_WorldGenAbstractTree extends Compat_WorldGenerator {
	private CompatI_WorldGenAbstractTree wrapper;

	// When called from Mod
	public Compat_WorldGenAbstractTree() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_WorldGenAbstractTree.class, this));
	}

	// When called from child
	protected Compat_WorldGenAbstractTree(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_WorldGenAbstractTree(WorldGenAbstractTree original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_WorldGenAbstractTree.class, original));
	}

	protected void initialize(CompatI_WorldGenAbstractTree wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public WorldGenAbstractTree getReal() {
		return wrapper.get();
	}
}
