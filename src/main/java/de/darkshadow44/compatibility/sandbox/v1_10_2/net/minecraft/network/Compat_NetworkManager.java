package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.network;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.network.NetworkManager;

public class Compat_NetworkManager {
	private CompatI_NetworkManager wrapper;

	// When called from Mod
	public Compat_NetworkManager() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_NetworkManager.class, this));
	}

	// When called from child
	protected Compat_NetworkManager(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_NetworkManager(NetworkManager original) {
		this.initialize(Factory.createWrapper(CompatI_NetworkManager.class, original));
	}

	protected void initialize(CompatI_NetworkManager wrapper) {
		this.wrapper = wrapper;
	}

	public NetworkManager getReal() {
		return wrapper.get();
	}
}
