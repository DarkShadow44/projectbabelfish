package compat.sandbox.net.minecraft.entity.passive;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.entity.passive.EntityChicken;

public class Compat_EntityChicken extends Compat_EntityAnimal {
	private CompatI_EntityChicken wrapper;

	// When called from Mod
	public Compat_EntityChicken() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityChicken.class, this));
	}

	// When called from child
	protected Compat_EntityChicken(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityChicken(EntityChicken original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityChicken.class, original));
	}

	protected void initialize(CompatI_EntityChicken wrapper) {
		this.wrapper = wrapper;
	}

	public EntityChicken getReal() {
		return wrapper.get();
	}
}
