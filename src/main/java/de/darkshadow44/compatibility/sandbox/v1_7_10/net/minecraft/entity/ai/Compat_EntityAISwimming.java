package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.ai;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.ai.EntityAISwimming;

public class Compat_EntityAISwimming extends Compat_EntityAIBase {
	private CompatI_EntityAISwimming wrapper;

	// When called from Mod
	public Compat_EntityAISwimming() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityAISwimming.class, this));
	}

	// When called from child
	protected Compat_EntityAISwimming(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityAISwimming(EntityAISwimming original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityAISwimming.class, original));
	}

	protected void initialize(CompatI_EntityAISwimming wrapper) {
		this.wrapper = wrapper;
	}

	public EntityAISwimming getReal() {
		return wrapper.get();
	}
}
