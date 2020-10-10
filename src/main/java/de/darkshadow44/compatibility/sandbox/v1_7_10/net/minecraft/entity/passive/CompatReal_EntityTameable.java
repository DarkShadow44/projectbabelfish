package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.passive;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.world.World;

public class CompatReal_EntityTameable extends EntityTameable implements CompatI_EntityTameable {
	@SuppressWarnings("unused")
	private Compat_EntityTameable thisFake;

	public CompatReal_EntityTameable(Compat_EntityTameable thisFake, World world) {
		super(world);
		this.thisFake = thisFake;
	}

	@Override
	public EntityTameable get() {
		return this;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		// TODO
		return null;
	}
}
