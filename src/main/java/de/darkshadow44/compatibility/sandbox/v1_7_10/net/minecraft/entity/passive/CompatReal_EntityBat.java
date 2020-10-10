package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.passive;

import net.minecraft.entity.passive.EntityBat;
import net.minecraft.world.World;

public class CompatReal_EntityBat extends EntityBat implements CompatI_EntityBat {
	@SuppressWarnings("unused")
	private Compat_EntityBat thisFake;

	public CompatReal_EntityBat(Compat_EntityBat thisFake, World world) {
		super(world);
		this.thisFake = thisFake;
	}

	@Override
	public EntityBat get() {
		return this;
	}
}
