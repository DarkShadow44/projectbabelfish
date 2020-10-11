package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.monster;

import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.world.World;

public class CompatReal_EntityMagmaCube extends EntityMagmaCube implements CompatI_EntityMagmaCube {
	@SuppressWarnings("unused")
	private Compat_EntityMagmaCube thisFake;

	public CompatReal_EntityMagmaCube(Compat_EntityMagmaCube thisFake, World world) {
		super(world);
		this.thisFake = thisFake;
	}

	@Override
	public EntityMagmaCube get() {
		return this;
	}
}
