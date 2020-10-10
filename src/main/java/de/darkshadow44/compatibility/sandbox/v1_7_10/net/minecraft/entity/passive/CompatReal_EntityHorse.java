package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.passive;

import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.world.World;

public class CompatReal_EntityHorse extends EntityHorse implements CompatI_EntityHorse {
	@SuppressWarnings("unused")
	private Compat_EntityHorse thisFake;

	public CompatReal_EntityHorse(Compat_EntityHorse thisFake, World world) {
		super(world);
		this.thisFake = thisFake;
	}

	@Override
	public EntityHorse get() {
		return this;
	}
}
