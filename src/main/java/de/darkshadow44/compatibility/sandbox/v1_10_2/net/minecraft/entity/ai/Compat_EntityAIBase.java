package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.ai;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.ai.EntityAIBase;

public class Compat_EntityAIBase {
	private CompatI_EntityAIBase wrapper;

	// When called from Mod
	public Compat_EntityAIBase() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityAIBase.class, this));
	}

	// When called from child
	protected Compat_EntityAIBase(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_EntityAIBase(EntityAIBase original) {
		this.initialize(Factory.createWrapper(CompatI_EntityAIBase.class, original));
	}

	protected void initialize(CompatI_EntityAIBase wrapper) {
		this.wrapper = wrapper;
	}

	public EntityAIBase getReal() {
		return wrapper.get();
	}
}
