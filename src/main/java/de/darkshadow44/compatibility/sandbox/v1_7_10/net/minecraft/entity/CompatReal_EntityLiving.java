package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;

public class CompatReal_EntityLiving extends EntityLiving implements CompatI_EntityLiving {
	@SuppressWarnings("unused")
	private Compat_EntityLiving thisFake;

	public CompatReal_EntityLiving(Compat_EntityLiving thisFake, World world) {
		super(world);
		this.thisFake = thisFake;
	}

	@Override
	public EntityLiving get() {
		return this;
	}
}
