package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.monster;

import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.world.World;

public class CompatReal_EntityGolem extends EntityGolem implements CompatI_EntityGolem {
	@SuppressWarnings("unused")
	private Compat_EntityGolem thisFake;

	public CompatReal_EntityGolem(Compat_EntityGolem thisFake, World world) {
		super(world);
		this.thisFake = thisFake;
	}

	@Override
	public EntityGolem get() {
		return this;
	}
}
