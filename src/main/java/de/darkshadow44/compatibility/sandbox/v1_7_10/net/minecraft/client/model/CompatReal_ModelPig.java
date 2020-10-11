package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.model;

import net.minecraft.client.model.ModelPig;

public class CompatReal_ModelPig extends ModelPig implements CompatI_ModelPig {
	@SuppressWarnings("unused")
	private Compat_ModelPig thisFake;

	public CompatReal_ModelPig(Compat_ModelPig thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public ModelPig get() {
		return this;
	}
}
