package compat.sandbox.net.minecraft.client.model;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.client.model.ModelPig;

public class Compat_ModelPig extends Compat_ModelQuadruped {
	private CompatI_ModelPig wrapper;

	// When called from Mod
	public Compat_ModelPig() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ModelPig.class, this));
	}

	// When called from child
	protected Compat_ModelPig(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ModelPig(ModelPig original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_ModelPig.class, original));
	}

	protected void initialize(CompatI_ModelPig wrapper) {
		this.wrapper = wrapper;
	}

	public ModelPig getReal() {
		return wrapper.get();
	}
}
