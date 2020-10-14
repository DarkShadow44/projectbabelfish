package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.ai;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.ai.EntityAIBase;

public class Compat_EntityAIBase {
	private EntityAIBase original;
	private CompatI_EntityAIBase thisReal;

	// When called from Mod
	public Compat_EntityAIBase() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityAIBase.class, this), null);
	}

	// When called from child
	protected Compat_EntityAIBase(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_EntityAIBase(EntityAIBase original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityAIBase thisReal, EntityAIBase original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityAIBase getReal() {
		return original == null ? thisReal.get() : original;
	}
}
