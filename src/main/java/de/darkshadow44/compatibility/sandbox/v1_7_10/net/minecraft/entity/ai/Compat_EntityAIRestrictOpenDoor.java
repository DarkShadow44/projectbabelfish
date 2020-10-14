package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.ai;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;

public class Compat_EntityAIRestrictOpenDoor extends Compat_EntityAIBase {
	private EntityAIRestrictOpenDoor original;
	private CompatI_EntityAIRestrictOpenDoor thisReal;

	// When called from Mod
	public Compat_EntityAIRestrictOpenDoor() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityAIRestrictOpenDoor.class, this), null);
	}

	// When called from child
	protected Compat_EntityAIRestrictOpenDoor(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityAIRestrictOpenDoor(EntityAIRestrictOpenDoor original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityAIRestrictOpenDoor thisReal, EntityAIRestrictOpenDoor original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityAIRestrictOpenDoor getReal() {
		return original == null ? thisReal.get() : original;
	}
}
