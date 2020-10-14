package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.ai;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;

public class Compat_EntityAIMoveTowardsRestriction extends Compat_EntityAIBase {
	private EntityAIMoveTowardsRestriction original;
	private CompatI_EntityAIMoveTowardsRestriction thisReal;

	// When called from Mod
	public Compat_EntityAIMoveTowardsRestriction() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityAIMoveTowardsRestriction.class, this), null);
	}

	// When called from child
	protected Compat_EntityAIMoveTowardsRestriction(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityAIMoveTowardsRestriction(EntityAIMoveTowardsRestriction original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityAIMoveTowardsRestriction thisReal, EntityAIMoveTowardsRestriction original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityAIMoveTowardsRestriction getReal() {
		return original == null ? thisReal.get() : original;
	}
}
