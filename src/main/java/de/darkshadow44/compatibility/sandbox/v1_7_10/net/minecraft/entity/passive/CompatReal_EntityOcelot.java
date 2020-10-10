package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.passive;

import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.world.World;

public class CompatReal_EntityOcelot extends EntityOcelot implements CompatI_EntityOcelot {
	@SuppressWarnings("unused")
	private Compat_EntityOcelot thisFake;

	public CompatReal_EntityOcelot(Compat_EntityOcelot thisFake, World world) {
		super(world);
		this.thisFake = thisFake;
	}

	@Override
	public EntityOcelot get() {
		return this;
	}
}
