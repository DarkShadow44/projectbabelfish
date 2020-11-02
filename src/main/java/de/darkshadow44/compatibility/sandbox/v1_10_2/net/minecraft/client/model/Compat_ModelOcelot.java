package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.model;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.model.ModelOcelot;

public class Compat_ModelOcelot extends Compat_ModelBase {
	private CompatI_ModelOcelot wrapper;

	// When called from Mod
	public Compat_ModelOcelot() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ModelOcelot.class, this));
	}

	// When called from child
	protected Compat_ModelOcelot(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ModelOcelot(ModelOcelot original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_ModelOcelot.class, original));
	}

	protected void initialize(CompatI_ModelOcelot wrapper) {
		this.wrapper = wrapper;
	}

	public ModelOcelot getReal() {
		return wrapper.get();
	}
}
