package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.passive;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.world.World;

public class CompatReal_EntityAnimal extends EntityAnimal implements CompatI_EntityAnimal {
	@SuppressWarnings("unused")
	private Compat_EntityAnimal thisFake;

	public CompatReal_EntityAnimal(Compat_EntityAnimal thisFake, World world) {
		super(world);
		this.thisFake = thisFake;
	}

	@Override
	public EntityAnimal get() {
		return this;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		// TODO
		return null;
	}
}
