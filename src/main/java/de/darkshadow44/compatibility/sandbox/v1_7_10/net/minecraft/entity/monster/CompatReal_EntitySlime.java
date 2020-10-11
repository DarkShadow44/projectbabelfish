package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.monster;

import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.world.World;

public class CompatReal_EntitySlime extends EntitySlime implements CompatI_EntitySlime {
	@SuppressWarnings("unused")
	private Compat_EntitySlime thisFake;

	public CompatReal_EntitySlime(Compat_EntitySlime thisFake, World world) {
		super(world);
		this.thisFake = thisFake;
	}

	@Override
	public EntitySlime get() {
		return this;
	}
}
