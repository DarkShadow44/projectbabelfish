package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.model;

import net.minecraft.client.model.ModelBiped;

public class CompatReal_ModelBiped extends ModelBiped implements CompatI_ModelBiped {
	@SuppressWarnings("unused")
	private Compat_ModelBiped thisFake;

	public CompatReal_ModelBiped(Compat_ModelBiped thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public ModelBiped get() {
		return this;
	}
}
