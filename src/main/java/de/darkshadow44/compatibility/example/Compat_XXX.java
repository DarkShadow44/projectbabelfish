package de.darkshadow44.compatibility.example;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;

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
