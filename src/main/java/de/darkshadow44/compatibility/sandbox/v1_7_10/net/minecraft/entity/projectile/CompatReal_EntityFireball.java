package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.projectile;

import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class CompatReal_EntityFireball extends EntityFireball implements CompatI_EntityFireball {
	@SuppressWarnings("unused")
	private Compat_EntityFireball thisFake;

	public CompatReal_EntityFireball(Compat_EntityFireball thisFake, World world) {
		super(world);
		this.thisFake = thisFake;
	}

	@Override
	public EntityFireball get() {
		return this;
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		// TODO
	}
}
