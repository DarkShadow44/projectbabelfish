package compat.sandbox.net.minecraft.entity.ai;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.entity.ai.EntityAIOpenDoor;

public class Compat_EntityAIOpenDoor extends Compat_EntityAIDoorInteract {
	private CompatI_EntityAIOpenDoor wrapper;

	// When called from Mod
	public Compat_EntityAIOpenDoor() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityAIOpenDoor.class, this));
	}

	// When called from child
	protected Compat_EntityAIOpenDoor(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityAIOpenDoor(EntityAIOpenDoor original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityAIOpenDoor.class, original));
	}

	protected void initialize(CompatI_EntityAIOpenDoor wrapper) {
		this.wrapper = wrapper;
	}

	public EntityAIOpenDoor getReal() {
		return wrapper.get();
	}
}
