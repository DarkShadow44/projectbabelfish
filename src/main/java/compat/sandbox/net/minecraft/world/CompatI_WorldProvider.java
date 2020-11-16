package compat.sandbox.net.minecraft.world;

import net.minecraft.world.WorldProvider;

public interface CompatI_WorldProvider {
	public WorldProvider get();

	public int getDimensionSuper();
}
