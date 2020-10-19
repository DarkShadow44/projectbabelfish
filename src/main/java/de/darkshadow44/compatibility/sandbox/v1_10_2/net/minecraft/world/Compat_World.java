package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.world.World;

public class Compat_World implements Compat_IBlockAccess {
	private World original;
	private CompatI_World thisReal;

	// When called from Mod
	public Compat_World() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_World.class, this), null);
	}

	// When called from child
	protected Compat_World(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_World(World original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_World thisReal, World original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public World getReal() {
		return original == null ? thisReal.get() : original;
	}
}
