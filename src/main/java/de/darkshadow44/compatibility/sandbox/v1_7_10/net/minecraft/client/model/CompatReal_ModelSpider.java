package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.model;

import net.minecraft.client.model.ModelSpider;

public class CompatReal_ModelSpider extends ModelSpider implements CompatI_ModelSpider {
	@SuppressWarnings("unused")
	private Compat_ModelSpider thisFake;

	public CompatReal_ModelSpider(Compat_ModelSpider thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public ModelSpider get() {
		return this;
	}
}
