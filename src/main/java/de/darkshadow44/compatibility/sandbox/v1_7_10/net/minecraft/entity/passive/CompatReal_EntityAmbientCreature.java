package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.passive;

import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.world.World;

public class CompatReal_EntityAmbientCreature extends EntityAmbientCreature implements CompatI_EntityAmbientCreature {
	@SuppressWarnings("unused")
	private Compat_EntityAmbientCreature thisFake;

	public CompatReal_EntityAmbientCreature(Compat_EntityAmbientCreature thisFake, World world) {
		super(world);
		this.thisFake = thisFake;
	}

	@Override
	public EntityAmbientCreature get() {
		return this;
	}
}
