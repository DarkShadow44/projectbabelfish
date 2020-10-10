package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.passive;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.world.World;

public class CompatReal_EntityVillager extends EntityVillager implements CompatI_EntityVillager {
	@SuppressWarnings("unused")
	private Compat_EntityVillager thisFake;

	public CompatReal_EntityVillager(Compat_EntityVillager thisFake, World world) {
		super(world);
		this.thisFake = thisFake;
	}

	@Override
	public EntityVillager get() {
		return this;
	}
}
