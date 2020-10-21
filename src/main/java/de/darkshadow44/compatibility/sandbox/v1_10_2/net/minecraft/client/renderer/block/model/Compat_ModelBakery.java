package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.model;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.renderer.block.model.ModelBakery;

public class Compat_ModelBakery {
	private ModelBakery original;
	private CompatI_ModelBakery thisReal;

	// When called from Mod
	public Compat_ModelBakery() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ModelBakery.class, this), null);
	}

	// When called from child
	protected Compat_ModelBakery(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_ModelBakery(ModelBakery original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_ModelBakery thisReal, ModelBakery original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public ModelBakery getReal() {
		return original == null ? thisReal.get() : original;
	}
}
