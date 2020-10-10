package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.world.World;

public class CompatReal_EntityAgeable extends EntityAgeable implements CompatI_EntityAgeable {
	@SuppressWarnings("unused")
	private Compat_EntityAgeable thisFake;

	public CompatReal_EntityAgeable(Compat_EntityAgeable thisFake, World world) {
		super(world);
		this.thisFake = thisFake;
	}

	@Override
	public EntityAgeable get() {
		return this;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		// TODO
		return null;
	}
}
