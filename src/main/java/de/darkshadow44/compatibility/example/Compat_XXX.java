package de.darkshadow44.compatibility.example;

import de.darkshadow44.compatibility.core.ParentSelector;

public class Compat_XXX {
	private XXX original;
	private CompatI_XXX thisReal;

	// When called from Mod
	public Compat_XXX() {
		initialize(new CompatReal_XXX(this), null);
	}

	// When called from child
	protected Compat_XXX(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_XXX(XXX original) {
		initialize(null, original);
	}

	protected void initialize(CompatI_XXX thisReal, XXX original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public XXX getReal() {
		return original == null ? thisReal.get() : original;
	}
}
