package de.darkshadow44.compatibility.example;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;

public class Compat_XXX {
	private XXX original;
	private CompatI_XXX thisReal;

	// When called from Mod
	public Compat_XXX() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_XXX.class, this), null);
	}

	// When called from child
	protected Compat_XXX(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_XXX(XXX original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_XXX thisReal, XXX original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public XXX getReal() {
		return original == null ? thisReal.get() : original;
	}
}
