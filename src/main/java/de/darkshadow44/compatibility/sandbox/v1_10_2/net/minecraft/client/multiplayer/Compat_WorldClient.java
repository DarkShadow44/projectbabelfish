package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.multiplayer;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world.Compat_World;
import net.minecraft.client.multiplayer.WorldClient;

public class Compat_WorldClient extends Compat_World {
	private CompatI_WorldClient wrapper;

	// When called from Mod
	public Compat_WorldClient() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_WorldClient.class, this));
	}

	// When called from child
	protected Compat_WorldClient(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_WorldClient(WorldClient original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_WorldClient.class, original));
	}

	protected void initialize(CompatI_WorldClient wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public WorldClient getReal() {
		return wrapper.get();
	}
}
