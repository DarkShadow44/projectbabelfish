package compat.sandbox.net.minecraft.entity.passive;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.entity.passive.EntityCow;

public class Compat_EntityCow extends Compat_EntityAnimal {
	private CompatI_EntityCow wrapper;

	// When called from Mod
	public Compat_EntityCow() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityCow.class, this));
	}

	// When called from child
	protected Compat_EntityCow(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityCow(EntityCow original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityCow.class, original));
	}

	protected void initialize(CompatI_EntityCow wrapper) {
		this.wrapper = wrapper;
	}

	public EntityCow getReal() {
		return wrapper.get();
	}
}
