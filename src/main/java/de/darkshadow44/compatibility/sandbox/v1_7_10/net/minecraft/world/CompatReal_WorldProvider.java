package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.world;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;

public class CompatReal_WorldProvider extends WorldProvider implements CompatI_WorldProvider {
	@SuppressWarnings("unused")
	private Compat_WorldProvider thisFake;

	public CompatReal_WorldProvider(Compat_WorldProvider thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public WorldProvider get() {
		return this;
	}

	@Override
	public DimensionType getDimensionType() {
		// TODO
		return null;
	}
}
