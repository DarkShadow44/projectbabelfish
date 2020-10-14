package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.ai;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.ai.EntityAIHurtByTarget;

public class Compat_EntityAIHurtByTarget extends Compat_EntityAITarget {
	private EntityAIHurtByTarget original;
	private CompatI_EntityAIHurtByTarget thisReal;

	// When called from Mod
	public Compat_EntityAIHurtByTarget() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityAIHurtByTarget.class, this), null);
	}

	// When called from child
	protected Compat_EntityAIHurtByTarget(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityAIHurtByTarget(EntityAIHurtByTarget original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityAIHurtByTarget thisReal, EntityAIHurtByTarget original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityAIHurtByTarget getReal() {
		return original == null ? thisReal.get() : original;
	}
}
