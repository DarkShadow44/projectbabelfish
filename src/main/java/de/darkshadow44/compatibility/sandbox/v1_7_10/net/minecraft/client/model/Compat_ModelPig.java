package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.model;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
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
