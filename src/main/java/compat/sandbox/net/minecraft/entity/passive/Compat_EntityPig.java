package compat.sandbox.net.minecraft.entity.passive;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.entity.passive.EntityPig;

public class Compat_EntityPig extends Compat_EntityAnimal {
	private CompatI_EntityPig wrapper;

	// When called from Mod
	public Compat_EntityPig() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityPig.class, this));
	}

	// When called from child
	protected Compat_EntityPig(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityPig(EntityPig original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityPig.class, original));
	}

	protected void initialize(CompatI_EntityPig wrapper) {
		this.wrapper = wrapper;
	}

	public EntityPig getReal() {
		return wrapper.get();
	}
}
