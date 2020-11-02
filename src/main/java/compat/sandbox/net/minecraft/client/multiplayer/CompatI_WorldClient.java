package compat.sandbox.net.minecraft.client.multiplayer;

import compat.sandbox.net.minecraft.world.CompatI_World;
import net.minecraft.client.multiplayer.WorldClient;

public interface CompatI_WorldClient extends CompatI_World {
	public WorldClient get();
}
