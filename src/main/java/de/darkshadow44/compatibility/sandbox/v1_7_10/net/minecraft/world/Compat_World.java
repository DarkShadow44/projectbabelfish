package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.world;

import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.world.World;

public class Compat_World {
	private World original;
	private CompatI_World thisReal;

	// When called from Mod
	public Compat_World() {
		initialize(new CompatReal_World(this), null);
	}

	// When called from child
	protected Compat_World(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_World(World original) {
		initialize(null, original);
	}

	protected void initialize(CompatI_World thisReal, World original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public World getReal() {
		return original == null ? thisReal.get() : original;
	}
}
