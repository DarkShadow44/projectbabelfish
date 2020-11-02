package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.ai;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.ai.EntityAITarget;

public class Compat_EntityAITarget extends Compat_EntityAIBase {
	private CompatI_EntityAITarget wrapper;

	// When called from Mod
	public Compat_EntityAITarget() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityAITarget.class, this));
	}

	// When called from child
	protected Compat_EntityAITarget(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityAITarget(EntityAITarget original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityAITarget.class, original));
	}

	protected void initialize(CompatI_EntityAITarget wrapper) {
		this.wrapper = wrapper;
	}

	public EntityAITarget getReal() {
		return wrapper.get();
	}
}
