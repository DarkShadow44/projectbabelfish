package compat.sandbox.net.minecraft.server.management;

import net.minecraft.server.management.PlayerInteractionManager;

public interface CompatI_PlayerInteractionManager {
	public PlayerInteractionManager get();

	public double getBlockReachDistanceSuper();
}
