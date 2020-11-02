package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.ai;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
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
