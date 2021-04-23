package compat.sandbox.net.minecraft.entity.monster;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.entity.monster.EntityCreeper;

public class Compat_EntityCreeper extends Compat_EntityMob {
	private CompatI_EntityCreeper wrapper;

	// When called from Mod
	public Compat_EntityCreeper() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityCreeper.class, this));
	}

	// When called from child
	protected Compat_EntityCreeper(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityCreeper(EntityCreeper original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityCreeper.class, original));
	}

	protected void initialize(CompatI_EntityCreeper wrapper) {
		this.wrapper = wrapper;
	}

	public EntityCreeper getReal() {
		return wrapper.get();
	}
}
