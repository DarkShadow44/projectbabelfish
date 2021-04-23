package compat.sandbox.net.minecraft.entity.ai;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;

public class Compat_EntityAIRestrictOpenDoor extends Compat_EntityAIBase {
	private CompatI_EntityAIRestrictOpenDoor wrapper;

	// When called from Mod
	public Compat_EntityAIRestrictOpenDoor() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityAIRestrictOpenDoor.class, this));
	}

	// When called from child
	protected Compat_EntityAIRestrictOpenDoor(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityAIRestrictOpenDoor(EntityAIRestrictOpenDoor original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityAIRestrictOpenDoor.class, original));
	}

	protected void initialize(CompatI_EntityAIRestrictOpenDoor wrapper) {
		this.wrapper = wrapper;
	}

	public EntityAIRestrictOpenDoor getReal() {
		return wrapper.get();
	}
}
