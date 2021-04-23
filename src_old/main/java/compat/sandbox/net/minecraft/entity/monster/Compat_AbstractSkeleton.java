package compat.sandbox.net.minecraft.entity.monster;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.entity.monster.AbstractSkeleton;

public class Compat_AbstractSkeleton extends Compat_EntityMob {
	private CompatI_AbstractSkeleton wrapper;

	// When called from Mod
	public Compat_AbstractSkeleton() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_AbstractSkeleton.class, this));
	}

	// When called from child
	protected Compat_AbstractSkeleton(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_AbstractSkeleton(AbstractSkeleton original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_AbstractSkeleton.class, original));
	}

	protected void initialize(CompatI_AbstractSkeleton wrapper) {
		this.wrapper = wrapper;
	}

	public AbstractSkeleton getReal() {
		return wrapper.get();
	}
}
