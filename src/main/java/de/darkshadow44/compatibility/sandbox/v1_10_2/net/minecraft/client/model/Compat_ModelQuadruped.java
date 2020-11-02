package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.model;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.model.ModelQuadruped;

public class Compat_ModelQuadruped extends Compat_ModelBase {
	private CompatI_ModelQuadruped wrapper;

	// When called from Mod
	public Compat_ModelQuadruped(int p1, float p2) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ModelQuadruped.class, this, p1, p2));
	}

	// When called from child
	protected Compat_ModelQuadruped(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ModelQuadruped(ModelQuadruped original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_ModelQuadruped.class, original));
	}

	protected void initialize(CompatI_ModelQuadruped wrapper) {
		this.wrapper = wrapper;
	}

	public ModelQuadruped getReal() {
		return wrapper.get();
	}
}
