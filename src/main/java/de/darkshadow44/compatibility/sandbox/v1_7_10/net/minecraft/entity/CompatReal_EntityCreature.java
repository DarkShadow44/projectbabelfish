package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity;

import net.minecraft.entity.EntityCreature;
import net.minecraft.world.World;

public class CompatReal_EntityCreature extends EntityCreature implements CompatI_EntityCreature {
	@SuppressWarnings("unused")
	private Compat_EntityCreature thisFake;

	public CompatReal_EntityCreature(Compat_EntityCreature thisFake, World world) {
		super(world);
		this.thisFake = thisFake;
	}

	@Override
	public EntityCreature get() {
		return this;
	}
}
