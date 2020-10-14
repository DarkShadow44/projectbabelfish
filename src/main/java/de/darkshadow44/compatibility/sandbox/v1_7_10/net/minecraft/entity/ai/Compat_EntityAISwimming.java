package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.ai;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.ai.EntityAISwimming;

public class Compat_EntityAISwimming extends Compat_EntityAIBase {
	private EntityAISwimming original;
	private CompatI_EntityAISwimming thisReal;

	// When called from Mod
	public Compat_EntityAISwimming() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityAISwimming.class, this), null);
	}

	// When called from child
	protected Compat_EntityAISwimming(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityAISwimming(EntityAISwimming original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityAISwimming thisReal, EntityAISwimming original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityAISwimming getReal() {
		return original == null ? thisReal.get() : original;
	}
}
