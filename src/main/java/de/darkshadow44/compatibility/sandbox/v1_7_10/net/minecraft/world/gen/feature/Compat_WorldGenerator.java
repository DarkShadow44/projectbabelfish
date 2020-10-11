package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.world.gen.feature;

import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.world.gen.feature.WorldGenerator;

public class Compat_WorldGenerator {
	private WorldGenerator original;
	private CompatI_WorldGenerator thisReal;

	// When called from Mod
	public Compat_WorldGenerator() {
		initialize(new CompatReal_WorldGenerator(this), null);
	}

	// When called from child
	protected Compat_WorldGenerator(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_WorldGenerator(WorldGenerator original) {
		initialize(null, original);
	}

	protected void initialize(CompatI_WorldGenerator thisReal, WorldGenerator original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public WorldGenerator getReal() {
		return original == null ? thisReal.get() : original;
	}
}
