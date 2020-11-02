package compat.sandbox.net.minecraft.server.management;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.server.management.PlayerInteractionManager;

public class Compat_PlayerInteractionManager {
	private CompatI_PlayerInteractionManager wrapper;

	// When called from Mod
	public Compat_PlayerInteractionManager() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_PlayerInteractionManager.class, this));
	}

	// When called from child
	protected Compat_PlayerInteractionManager(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_PlayerInteractionManager(PlayerInteractionManager original) {
		this.initialize(Factory.createWrapper(CompatI_PlayerInteractionManager.class, original));
	}

	protected void initialize(CompatI_PlayerInteractionManager wrapper) {
		this.wrapper = wrapper;
	}

	public PlayerInteractionManager getReal() {
		return wrapper.get();
	}

	public double Compat_getBlockReachDistance() {
		return wrapper.getBlockReachDistanceSuper();
	}
}
