package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.world;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.world.WorldProvider;

public class Compat_WorldProvider {
	private WorldProvider original;
	private CompatI_WorldProvider thisReal;

	// When called from Mod
	public Compat_WorldProvider() {
		this.initialize(Factory.create(CtorPos.POS1, this), null);
	}

	// When called from child
	protected Compat_WorldProvider(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_WorldProvider(WorldProvider original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_WorldProvider thisReal, WorldProvider original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public WorldProvider getReal() {
		return original == null ? thisReal.get() : original;
	}
}
