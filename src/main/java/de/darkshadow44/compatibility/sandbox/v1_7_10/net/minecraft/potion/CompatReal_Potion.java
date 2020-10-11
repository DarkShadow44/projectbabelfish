package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.potion;

import net.minecraft.potion.Potion;

public class CompatReal_Potion extends Potion implements CompatI_Potion {
	@SuppressWarnings("unused")
	private Compat_Potion thisFake;

	public CompatReal_Potion(Compat_Potion thisFake, boolean isBadEffect, int color) {
		super(isBadEffect, color);
		this.thisFake = thisFake;
	}

	@Override
	public Potion get() {
		return this;
	}
}
