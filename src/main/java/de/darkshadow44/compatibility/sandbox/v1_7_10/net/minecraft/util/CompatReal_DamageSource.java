package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.util;

import net.minecraft.util.DamageSource;

public class CompatReal_DamageSource extends DamageSource implements CompatI_DamageSource {
	@SuppressWarnings("unused")
	private Compat_DamageSource thisFake;

	public CompatReal_DamageSource(Compat_DamageSource thisFake, String p1) {
		super(p1);
		this.thisFake = thisFake;
	}

	@Override
	public DamageSource get() {
		return this;
	}
}
