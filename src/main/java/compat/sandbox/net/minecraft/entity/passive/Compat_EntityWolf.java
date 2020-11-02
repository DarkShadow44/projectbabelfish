package compat.sandbox.net.minecraft.entity.passive;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.entity.passive.EntityWolf;

public class Compat_EntityWolf extends Compat_EntityTameable {
	private CompatI_EntityWolf wrapper;

	// When called from Mod
	public Compat_EntityWolf() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityWolf.class, this));
	}

	// When called from child
	protected Compat_EntityWolf(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityWolf(EntityWolf original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityWolf.class, original));
	}

	protected void initialize(CompatI_EntityWolf wrapper) {
		this.wrapper = wrapper;
	}

	public EntityWolf getReal() {
		return wrapper.get();
	}
}
