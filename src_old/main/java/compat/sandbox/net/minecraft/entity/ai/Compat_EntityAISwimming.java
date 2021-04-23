package compat.sandbox.net.minecraft.entity.ai;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.entity.ai.EntityAISwimming;

public class Compat_EntityAISwimming extends Compat_EntityAIBase {
	private CompatI_EntityAISwimming wrapper;

	// When called from Mod
	public Compat_EntityAISwimming() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityAISwimming.class, this));
	}

	// When called from child
	protected Compat_EntityAISwimming(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityAISwimming(EntityAISwimming original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityAISwimming.class, original));
	}

	protected void initialize(CompatI_EntityAISwimming wrapper) {
		this.wrapper = wrapper;
	}

	public EntityAISwimming getReal() {
		return wrapper.get();
	}
}
