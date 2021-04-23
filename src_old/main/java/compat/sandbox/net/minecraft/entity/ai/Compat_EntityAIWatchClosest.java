package compat.sandbox.net.minecraft.entity.ai;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.entity.ai.EntityAIWatchClosest;

public class Compat_EntityAIWatchClosest extends Compat_EntityAIBase {
	private CompatI_EntityAIWatchClosest wrapper;

	// When called from Mod
	public Compat_EntityAIWatchClosest() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityAIWatchClosest.class, this));
	}

	// When called from child
	protected Compat_EntityAIWatchClosest(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityAIWatchClosest(EntityAIWatchClosest original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityAIWatchClosest.class, original));
	}

	protected void initialize(CompatI_EntityAIWatchClosest wrapper) {
		this.wrapper = wrapper;
	}

	public EntityAIWatchClosest getReal() {
		return wrapper.get();
	}
}
