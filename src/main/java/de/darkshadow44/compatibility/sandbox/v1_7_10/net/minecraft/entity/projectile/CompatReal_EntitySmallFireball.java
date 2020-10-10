package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.projectile;

import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.world.World;

public class CompatReal_EntitySmallFireball extends EntitySmallFireball implements CompatI_EntitySmallFireball {
	@SuppressWarnings("unused")
	private Compat_EntitySmallFireball thisFake;

	public CompatReal_EntitySmallFireball(Compat_EntitySmallFireball thisFake, World world) {
		super(world);
		this.thisFake = thisFake;
	}

	@Override
	public EntitySmallFireball get() {
		return this;
	}
}
