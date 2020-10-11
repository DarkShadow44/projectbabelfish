package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.model;

import net.minecraft.client.model.ModelBase;

public class CompatReal_ModelBase extends ModelBase implements CompatI_ModelBase {
	@SuppressWarnings("unused")
	private Compat_ModelBase thisFake;

	public CompatReal_ModelBase(Compat_ModelBase thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public ModelBase get() {
		return this;
	}
}
