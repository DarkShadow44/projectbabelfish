package compat.sandbox.net.minecraft.entity.ai;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.entity.ai.EntityAIWander;

public class Compat_EntityAIWander extends Compat_EntityAIBase {
	private CompatI_EntityAIWander wrapper;

	// When called from Mod
	public Compat_EntityAIWander() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityAIWander.class, this));
	}

	// When called from child
	protected Compat_EntityAIWander(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityAIWander(EntityAIWander original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityAIWander.class, original));
	}

	protected void initialize(CompatI_EntityAIWander wrapper) {
		this.wrapper = wrapper;
	}

	public EntityAIWander getReal() {
		return wrapper.get();
	}
}
