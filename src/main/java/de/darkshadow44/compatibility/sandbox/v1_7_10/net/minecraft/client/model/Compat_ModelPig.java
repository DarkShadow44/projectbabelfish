package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.model;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.model.ModelPig;

public class Compat_ModelPig extends Compat_ModelQuadruped {
	private ModelPig original;
	private CompatI_ModelPig thisReal;

	// When called from Mod
	public Compat_ModelPig() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ModelPig.class, this), null);
	}

	// When called from child
	protected Compat_ModelPig(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ModelPig(ModelPig original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_ModelPig thisReal, ModelPig original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public ModelPig getReal() {
		return original == null ? thisReal.get() : original;
	}
}
