package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.world;

import net.minecraft.world.WorldServer;

public class CompatReal_WorldServer extends WorldServer implements CompatI_WorldServer {
	@SuppressWarnings("unused")
	private Compat_WorldServer thisFake;

	public CompatReal_WorldServer(Compat_WorldServer thisFake) {
		super(null, null, null, 0, null); // TODO
		this.thisFake = thisFake;
	}

	@Override
	public WorldServer get() {
		return this;
	}
}
