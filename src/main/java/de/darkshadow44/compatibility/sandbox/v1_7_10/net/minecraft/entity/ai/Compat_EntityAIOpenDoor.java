package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.ai;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.ai.EntityAIOpenDoor;

public class Compat_EntityAIOpenDoor extends Compat_EntityAIDoorInteract {
	private EntityAIOpenDoor original;
	private CompatI_EntityAIOpenDoor thisReal;

	// When called from Mod
	public Compat_EntityAIOpenDoor() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityAIOpenDoor.class, this), null);
	}

	// When called from child
	protected Compat_EntityAIOpenDoor(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityAIOpenDoor(EntityAIOpenDoor original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityAIOpenDoor thisReal, EntityAIOpenDoor original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityAIOpenDoor getReal() {
		return original == null ? thisReal.get() : original;
	}
}
