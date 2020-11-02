package compat.example;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;

public class Compat_XXX {
	private CompatI_XXX wrapper;

	// When called from Mod
	public Compat_XXX() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_XXX.class, this));
	}

	// When called from child
	protected Compat_XXX(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_XXX(XXX original) {
		this.initialize(Factory.createWrapper(CompatI_XXX.class, original));
	}

	protected void initialize(CompatI_XXX wrapper) {
		this.wrapper = wrapper;
	}

	public XXX getReal() {
		return wrapper.get();
	}
}
