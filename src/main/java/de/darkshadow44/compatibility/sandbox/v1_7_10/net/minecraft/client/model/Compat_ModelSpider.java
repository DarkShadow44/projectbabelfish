package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.model;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.model.ModelSpider;

public class Compat_ModelSpider extends Compat_ModelBase {
	private CompatI_ModelSpider wrapper;

	// When called from Mod
	public Compat_ModelSpider() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ModelSpider.class, this));
	}

	// When called from child
	protected Compat_ModelSpider(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ModelSpider(ModelSpider original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_ModelSpider.class, original));
	}

	protected void initialize(CompatI_ModelSpider wrapper) {
		this.wrapper = wrapper;
	}

	public ModelSpider getReal() {
		return wrapper.get();
	}
}
