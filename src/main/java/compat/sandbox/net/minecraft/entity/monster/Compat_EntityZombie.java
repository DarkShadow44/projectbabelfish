package compat.sandbox.net.minecraft.entity.monster;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.entity.monster.EntityZombie;

public class Compat_EntityZombie extends Compat_EntityMob {
	private CompatI_EntityZombie wrapper;

	// When called from Mod
	public Compat_EntityZombie() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityZombie.class, this));
	}

	// When called from child
	protected Compat_EntityZombie(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityZombie(EntityZombie original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityZombie.class, original));
	}

	protected void initialize(CompatI_EntityZombie wrapper) {
		this.wrapper = wrapper;
	}

	public EntityZombie getReal() {
		return wrapper.get();
	}
}
