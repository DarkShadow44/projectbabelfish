package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.model;

import net.minecraft.client.model.ModelZombie;

public class CompatReal_ModelZombie extends ModelZombie implements CompatI_ModelZombie {
	@SuppressWarnings("unused")
	private Compat_ModelZombie thisFake;

	public CompatReal_ModelZombie(Compat_ModelZombie thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public ModelZombie get() {
		return this;
	}
}
