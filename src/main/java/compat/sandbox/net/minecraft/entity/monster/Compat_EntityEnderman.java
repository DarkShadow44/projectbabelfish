package compat.sandbox.net.minecraft.entity.monster;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.entity.monster.EntityEnderman;

public class Compat_EntityEnderman extends Compat_EntityMob {
	private CompatI_EntityEnderman wrapper;

	// When called from Mod
	public Compat_EntityEnderman() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityEnderman.class, this));
	}

	// When called from child
	protected Compat_EntityEnderman(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityEnderman(EntityEnderman original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityEnderman.class, original));
	}

	protected void initialize(CompatI_EntityEnderman wrapper) {
		this.wrapper = wrapper;
	}

	public EntityEnderman getReal() {
		return wrapper.get();
	}
}
