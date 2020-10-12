package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.model;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.model.ModelCreeper;

public class Compat_ModelCreeper extends Compat_ModelBase {
	private ModelCreeper original;
	private CompatI_ModelCreeper thisReal;

	// When called from Mod
	public Compat_ModelCreeper() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ModelCreeper.class, this), null);
	}

	// When called from child
	protected Compat_ModelCreeper(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ModelCreeper(ModelCreeper original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_ModelCreeper thisReal, ModelCreeper original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public ModelCreeper getReal() {
		return original == null ? thisReal.get() : original;
	}
}
