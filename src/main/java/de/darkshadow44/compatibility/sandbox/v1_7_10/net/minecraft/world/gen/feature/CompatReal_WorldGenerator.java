package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.world.gen.feature;

public class CompatReal_WorldGenerator extends WorldGenerator implements CompatI_WorldGenerator {
	@SuppressWarnings("unused")
	private Compat_WorldGenerator thisFake;

	public CompatReal_WorldGenerator(Compat_WorldGenerator thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public WorldGenerator get() {
		return this;
	}
}
