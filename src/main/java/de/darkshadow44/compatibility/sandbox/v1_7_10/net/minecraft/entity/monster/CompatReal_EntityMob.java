package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.monster;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

public class CompatReal_EntityMob extends EntityMob implements CompatI_EntityMob {
	@SuppressWarnings("unused")
	private Compat_EntityMob thisFake;

	public CompatReal_EntityMob(Compat_EntityMob thisFake, World world) {
		super(world);
		this.thisFake = thisFake;
	}

	@Override
	public EntityMob get() {
		return this;
	}
}
