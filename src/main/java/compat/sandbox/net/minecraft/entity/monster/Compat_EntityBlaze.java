package compat.sandbox.net.minecraft.entity.monster;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.entity.monster.EntityBlaze;

public class Compat_EntityBlaze extends Compat_EntityMob {
	private CompatI_EntityBlaze wrapper;

	// When called from Mod
	public Compat_EntityBlaze() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityBlaze.class, this));
	}

	// When called from child
	protected Compat_EntityBlaze(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityBlaze(EntityBlaze original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityBlaze.class, original));
	}

	protected void initialize(CompatI_EntityBlaze wrapper) {
		this.wrapper = wrapper;
	}

	public EntityBlaze getReal() {
		return wrapper.get();
	}
}
