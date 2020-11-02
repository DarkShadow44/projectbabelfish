package compat.sandbox.net.minecraft.entity;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.entity.EntityHanging;

public class Compat_EntityHanging extends Compat_Entity {
	private CompatI_EntityHanging wrapper;

	// When called from Mod
	public Compat_EntityHanging() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityHanging.class, this));
	}

	// When called from child
	protected Compat_EntityHanging(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityHanging(EntityHanging original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityHanging.class, original));
	}

	protected void initialize(CompatI_EntityHanging wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public EntityHanging getReal() {
		return wrapper.get();
	}
}
