package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.monster;

import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.world.World;

public class CompatReal_EntitySilverfish extends EntitySilverfish implements CompatI_EntitySilverfish {
	@SuppressWarnings("unused")
	private Compat_EntitySilverfish thisFake;

	public CompatReal_EntitySilverfish(Compat_EntitySilverfish thisFake, World world) {
		super(world);
		this.thisFake = thisFake;
	}

	@Override
	public EntitySilverfish get() {
		return this;
	}
}
