package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.util;

import net.minecraft.entity.Entity;
import net.minecraft.util.EntityDamageSourceIndirect;

public class CompatReal_EntityDamageSourceIndirect extends EntityDamageSourceIndirect implements CompatI_EntityDamageSourceIndirect {
	@SuppressWarnings("unused")
	private Compat_EntityDamageSourceIndirect thisFake;

	public CompatReal_EntityDamageSourceIndirect(Compat_EntityDamageSourceIndirect thisFake, String p1, Entity entity1, Entity entity2) {
		super(p1, entity1, entity2);
		this.thisFake = thisFake;
	}

	@Override
	public EntityDamageSourceIndirect get() {
		return this;
	}
}
