package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.model;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.model.ModelQuadruped;

public class Compat_ModelQuadruped extends Compat_ModelBase {
	private ModelQuadruped original;
	private CompatI_ModelQuadruped thisReal;

	// When called from Mod
	public Compat_ModelQuadruped(int p1, float p2) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ModelQuadruped.class, this, p1, p2), null);
	}

	// When called from child
	protected Compat_ModelQuadruped(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ModelQuadruped(ModelQuadruped original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_ModelQuadruped thisReal, ModelQuadruped original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public ModelQuadruped getReal() {
		return original == null ? thisReal.get() : original;
	}
}
