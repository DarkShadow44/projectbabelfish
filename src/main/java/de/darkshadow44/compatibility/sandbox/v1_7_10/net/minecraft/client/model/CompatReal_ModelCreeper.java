package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.model;

import net.minecraft.client.model.ModelCreeper;

public class CompatReal_ModelCreeper extends ModelCreeper implements CompatI_ModelCreeper {
	@SuppressWarnings("unused")
	private Compat_ModelCreeper thisFake;

	public CompatReal_ModelCreeper(Compat_ModelCreeper thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public ModelCreeper get() {
		return this;
	}
}
