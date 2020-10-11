package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.model;

import net.minecraft.client.model.ModelOcelot;

public class CompatReal_ModelOcelot extends ModelOcelot implements CompatI_ModelOcelot {
	@SuppressWarnings("unused")
	private Compat_ModelOcelot thisFake;

	public CompatReal_ModelOcelot(Compat_ModelOcelot thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public ModelOcelot get() {
		return this;
	}
}
