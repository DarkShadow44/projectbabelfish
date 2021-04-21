package compat.sandbox.net.minecraft.client.model;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.client.renderer.entity.model.ModelBiped;

public class Compat_ModelBiped extends Compat_ModelBase {
	private CompatI_ModelBiped wrapper;

	// When called from Mod
	public Compat_ModelBiped() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ModelBiped.class, this));
	}

	// When called from child
	protected Compat_ModelBiped(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ModelBiped(ModelBiped original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_ModelBiped.class, original));
	}

	protected void initialize(CompatI_ModelBiped wrapper) {
		this.wrapper = wrapper;
	}

	public ModelBiped getReal() {
		return wrapper.get();
	}
}
