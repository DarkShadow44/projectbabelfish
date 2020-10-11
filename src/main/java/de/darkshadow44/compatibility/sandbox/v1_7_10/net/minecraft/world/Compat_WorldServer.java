package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.world;

import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.world.WorldServer;

public class Compat_WorldServer extends Compat_World {
	private WorldServer original;
	private CompatI_WorldServer thisReal;

	// When called from Mod
	public Compat_WorldServer() {
		super(ParentSelector.NULL);
		this.initialize(new CompatReal_WorldServer(this), null);
	}

	// When called from child
	protected Compat_WorldServer(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_WorldServer(WorldServer original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_WorldServer thisReal, WorldServer original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public WorldServer getReal() {
		return original == null ? thisReal.get() : original;
	}
}
