package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.util;

import net.minecraft.entity.Entity;
import net.minecraft.util.EntityDamageSource;

public class CompatReal_EntityDamageSource extends EntityDamageSource implements CompatI_EntityDamageSource {
	@SuppressWarnings("unused")
	private Compat_EntityDamageSource thisFake;

	public CompatReal_EntityDamageSource(Compat_EntityDamageSource thisFake, String p1, Entity entity) {
		super(p1, entity);
		this.thisFake = thisFake;
	}

	@Override
	public EntityDamageSource get() {
		return this;
	}
}
