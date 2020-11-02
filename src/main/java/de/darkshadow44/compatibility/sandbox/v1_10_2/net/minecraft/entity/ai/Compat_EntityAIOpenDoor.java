package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.ai;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
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
