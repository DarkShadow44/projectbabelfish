package de.darkshadow44.compatibility.example;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;

public class Compat_ZZZ extends Compat_XXX {
	private CompatI_ZZZ wrapper;

	// When called from Mod
	public Compat_ZZZ() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ZZZ.class, this));
	}

	// When called from child
	protected Compat_ZZZ(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ZZZ(ZZZ original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_ZZZ.class, original));
	}

	protected void initialize(CompatI_ZZZ wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public ZZZ getReal() {
		return wrapper.get();
	}
}
