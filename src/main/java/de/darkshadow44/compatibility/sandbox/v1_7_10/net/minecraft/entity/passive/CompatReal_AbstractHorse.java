package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.passive;

import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.world.World;

public class CompatReal_AbstractHorse extends AbstractHorse implements CompatI_AbstractHorse {
	@SuppressWarnings("unused")
	private Compat_AbstractHorse thisFake;

	public CompatReal_AbstractHorse(Compat_AbstractHorse thisFake, World world) {
		super(world);
		this.thisFake = thisFake;
	}

	@Override
	public AbstractHorse get() {
		return this;
	}
}
