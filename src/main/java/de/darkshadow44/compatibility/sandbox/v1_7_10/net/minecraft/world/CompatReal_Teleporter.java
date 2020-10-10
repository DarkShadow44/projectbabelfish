package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.world;

import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class CompatReal_Teleporter extends Teleporter implements CompatI_Teleporter {
	@SuppressWarnings("unused")
	private Compat_Teleporter thisFake;

	public CompatReal_Teleporter(Compat_Teleporter thisFake, WorldServer world) {
		super(world);
		this.thisFake = thisFake;
	}

	@Override
	public Teleporter get() {
		return this;
	}
}
