package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.model;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.model.ModelVillager;

public class Compat_ModelVillager extends Compat_ModelBase {
	private CompatI_ModelVillager wrapper;

	// When called from Mod
	public Compat_ModelVillager(float p1) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ModelVillager.class, this, p1));
	}

	// When called from child
	protected Compat_ModelVillager(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ModelVillager(ModelVillager original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_ModelVillager.class, original));
	}

	protected void initialize(CompatI_ModelVillager wrapper) {
		this.wrapper = wrapper;
	}

	public ModelVillager getReal() {
		return wrapper.get();
	}
}
