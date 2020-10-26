package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.multiplayer;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world.Compat_World;
import net.minecraft.client.multiplayer.WorldClient;

public class Compat_WorldClient extends Compat_World {
	private WorldClient original;
	private CompatI_WorldClient thisReal;

	// When called from Mod
	public Compat_WorldClient() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_WorldClient.class, this), null);
	}

	// When called from child
	protected Compat_WorldClient(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_WorldClient(WorldClient original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_WorldClient thisReal, WorldClient original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public WorldClient getReal() {
		return original == null ? thisReal.get() : original;
	}
}
