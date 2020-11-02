package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.model;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.model.ModelBase;

public class Compat_ModelBase {
	private CompatI_ModelBase wrapper;

	// When called from Mod
	public Compat_ModelBase() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ModelBase.class, this));
	}

	// When called from child
	protected Compat_ModelBase(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_ModelBase(ModelBase original) {
		this.initialize(Factory.createWrapper(CompatI_ModelBase.class, original));
	}

	protected void initialize(CompatI_ModelBase wrapper) {
		this.wrapper = wrapper;
	}

	public ModelBase getReal() {
		return wrapper.get();
	}
}
