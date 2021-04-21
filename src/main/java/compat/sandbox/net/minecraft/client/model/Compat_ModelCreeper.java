package compat.sandbox.net.minecraft.client.model;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.client.renderer.entity.model.ModelCreeper;

public class Compat_ModelCreeper extends Compat_ModelBase {
	private CompatI_ModelCreeper wrapper;

	// When called from Mod
	public Compat_ModelCreeper() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ModelCreeper.class, this));
	}

	// When called from child
	protected Compat_ModelCreeper(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ModelCreeper(ModelCreeper original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_ModelCreeper.class, original));
	}

	protected void initialize(CompatI_ModelCreeper wrapper) {
		this.wrapper = wrapper;
	}

	public ModelCreeper getReal() {
		return wrapper.get();
	}
}
