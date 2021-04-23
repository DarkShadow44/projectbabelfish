package compat.sandbox.net.minecraft.entity.ai;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.entity.ai.EntityAIMoveIndoors;

public class Compat_EntityAIMoveIndoors extends Compat_EntityAIBase {
	private CompatI_EntityAIMoveIndoors wrapper;

	// When called from Mod
	public Compat_EntityAIMoveIndoors() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityAIMoveIndoors.class, this));
	}

	// When called from child
	protected Compat_EntityAIMoveIndoors(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityAIMoveIndoors(EntityAIMoveIndoors original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityAIMoveIndoors.class, original));
	}

	protected void initialize(CompatI_EntityAIMoveIndoors wrapper) {
		this.wrapper = wrapper;
	}

	public EntityAIMoveIndoors getReal() {
		return wrapper.get();
	}
}
