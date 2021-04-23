package compat.sandbox.net.minecraft.entity.ai;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;

public class Compat_EntityAIMoveTowardsRestriction extends Compat_EntityAIBase {
	private CompatI_EntityAIMoveTowardsRestriction wrapper;

	// When called from Mod
	public Compat_EntityAIMoveTowardsRestriction() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityAIMoveTowardsRestriction.class, this));
	}

	// When called from child
	protected Compat_EntityAIMoveTowardsRestriction(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityAIMoveTowardsRestriction(EntityAIMoveTowardsRestriction original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityAIMoveTowardsRestriction.class, original));
	}

	protected void initialize(CompatI_EntityAIMoveTowardsRestriction wrapper) {
		this.wrapper = wrapper;
	}

	public EntityAIMoveTowardsRestriction getReal() {
		return wrapper.get();
	}
}
