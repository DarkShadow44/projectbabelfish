package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.projectile;

import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.world.World;

public abstract class CompatReal_EntityThrowable extends EntityThrowable implements CompatI_EntityThrowable {
	@SuppressWarnings("unused")
	private Compat_EntityThrowable thisFake;

	public CompatReal_EntityThrowable(Compat_EntityThrowable thisFake, World world) {
		super(world);
		this.thisFake = thisFake;
	}

	@Override
	public EntityThrowable get() {
		return this;
	}
}
