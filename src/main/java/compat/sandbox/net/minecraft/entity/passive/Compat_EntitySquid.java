package compat.sandbox.net.minecraft.entity.passive;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.entity.passive.EntitySquid;

public class Compat_EntitySquid extends Compat_EntityWaterMob {
	private CompatI_EntitySquid wrapper;

	// When called from Mod
	public Compat_EntitySquid() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntitySquid.class, this));
	}

	// When called from child
	protected Compat_EntitySquid(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntitySquid(EntitySquid original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntitySquid.class, original));
	}

	protected void initialize(CompatI_EntitySquid wrapper) {
		this.wrapper = wrapper;
	}

	public EntitySquid getReal() {
		return wrapper.get();
	}
}
