package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.ai;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.ai.EntityAIMoveIndoors;

public class Compat_EntityAIMoveIndoors extends Compat_EntityAIBase {
	private EntityAIMoveIndoors original;
	private CompatI_EntityAIMoveIndoors thisReal;

	// When called from Mod
	public Compat_EntityAIMoveIndoors() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityAIMoveIndoors.class, this), null);
	}

	// When called from child
	protected Compat_EntityAIMoveIndoors(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityAIMoveIndoors(EntityAIMoveIndoors original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityAIMoveIndoors thisReal, EntityAIMoveIndoors original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityAIMoveIndoors getReal() {
		return original == null ? thisReal.get() : original;
	}
}
