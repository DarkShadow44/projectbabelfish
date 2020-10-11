package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.potion;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class CompatReal_PotionEffect extends PotionEffect implements CompatI_PotionEffect {
	@SuppressWarnings("unused")
	private Compat_PotionEffect thisFake;

	public CompatReal_PotionEffect(Compat_PotionEffect thisFake, Potion potion, int duration, int amplifier) {
		super(potion, duration, amplifier);
		this.thisFake = thisFake;
	}

	public CompatReal_PotionEffect(Compat_PotionEffect thisFake, Potion potion, int duration) {
		super(potion, duration);
		this.thisFake = thisFake;
	}

	@Override
	public PotionEffect get() {
		return this;
	}
}
