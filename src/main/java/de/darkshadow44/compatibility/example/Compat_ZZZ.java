package de.darkshadow44.compatibility.example;

import de.darkshadow44.compatibility.core.ParentSelector;

public class Compat_ZZZ extends Compat_XXX {
	private ZZZ original;
	private CompatI_ZZZ thisReal;

	// When called from Mod
	public Compat_ZZZ() {
		super(ParentSelector.NULL);
		this.initialize(new CompatReal_ZZZ(this), null);
	}

	// When called from child
	protected Compat_ZZZ(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ZZZ(ZZZ original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_ZZZ thisReal, ZZZ original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public ZZZ getReal() {
		return original == null ? thisReal.get() : original;
	}
}
