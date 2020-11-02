package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.model;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.model.ModelZombie;

public class Compat_ModelZombie extends Compat_ModelBiped {
	private CompatI_ModelZombie wrapper;

	// When called from Mod
	public Compat_ModelZombie() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ModelZombie.class, this));
	}

	// When called from child
	protected Compat_ModelZombie(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ModelZombie(ModelZombie original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_ModelZombie.class, original));
	}

	protected void initialize(CompatI_ModelZombie wrapper) {
		this.wrapper = wrapper;
	}

	public ModelZombie getReal() {
		return wrapper.get();
	}
}
