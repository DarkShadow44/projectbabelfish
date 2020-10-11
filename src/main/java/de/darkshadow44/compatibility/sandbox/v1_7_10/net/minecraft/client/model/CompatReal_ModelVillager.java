package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.model;

import net.minecraft.client.model.ModelVillager;

public class CompatReal_ModelVillager extends ModelVillager implements CompatI_ModelVillager {
	@SuppressWarnings("unused")
	private Compat_ModelVillager thisFake;

	public CompatReal_ModelVillager(Compat_ModelVillager thisFake, float p1) {
		super(p1);
		this.thisFake = thisFake;
	}

	@Override
	public ModelVillager get() {
		return this;
	}
}
