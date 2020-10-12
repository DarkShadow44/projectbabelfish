package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.model;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.model.ModelSpider;

public class Compat_ModelSpider extends Compat_ModelBase {
	private ModelSpider original;
	private CompatI_ModelSpider thisReal;

	// When called from Mod
	public Compat_ModelSpider() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ModelSpider.class, this), null);
	}

	// When called from child
	protected Compat_ModelSpider(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ModelSpider(ModelSpider original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_ModelSpider thisReal, ModelSpider original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public ModelSpider getReal() {
		return original == null ? thisReal.get() : original;
	}
}
