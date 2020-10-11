package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.model;

import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.model.ModelBase;

public class Compat_ModelBase {
	private ModelBase original;
	private CompatI_ModelBase thisReal;

	// When called from Mod
	public Compat_ModelBase() {
		initialize(new CompatReal_ModelBase(this), null);
	}

	// When called from child
	protected Compat_ModelBase(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_ModelBase(ModelBase original) {
		initialize(null, original);
	}

	protected void initialize(CompatI_ModelBase thisReal, ModelBase original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public ModelBase getReal() {
		return original == null ? thisReal.get() : original;
	}
}
