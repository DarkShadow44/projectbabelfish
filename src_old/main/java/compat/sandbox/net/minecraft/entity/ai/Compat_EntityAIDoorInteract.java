package compat.sandbox.net.minecraft.entity.ai;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.entity.ai.EntityAIDoorInteract;

public class Compat_EntityAIDoorInteract extends Compat_EntityAIBase {
	private CompatI_EntityAIDoorInteract wrapper;

	// When called from Mod
	public Compat_EntityAIDoorInteract() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityAIDoorInteract.class, this));
	}

	// When called from child
	protected Compat_EntityAIDoorInteract(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityAIDoorInteract(EntityAIDoorInteract original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityAIDoorInteract.class, original));
	}

	protected void initialize(CompatI_EntityAIDoorInteract wrapper) {
		this.wrapper = wrapper;
	}

	public EntityAIDoorInteract getReal() {
		return wrapper.get();
	}
}
