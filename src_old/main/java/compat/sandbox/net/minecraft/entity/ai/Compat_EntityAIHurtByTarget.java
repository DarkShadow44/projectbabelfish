package compat.sandbox.net.minecraft.entity.ai;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.entity.ai.EntityAIHurtByTarget;

public class Compat_EntityAIHurtByTarget extends Compat_EntityAITarget {
	private CompatI_EntityAIHurtByTarget wrapper;

	// When called from Mod
	public Compat_EntityAIHurtByTarget() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityAIHurtByTarget.class, this));
	}

	// When called from child
	protected Compat_EntityAIHurtByTarget(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityAIHurtByTarget(EntityAIHurtByTarget original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityAIHurtByTarget.class, original));
	}

	protected void initialize(CompatI_EntityAIHurtByTarget wrapper) {
		this.wrapper = wrapper;
	}

	public EntityAIHurtByTarget getReal() {
		return wrapper.get();
	}
}
