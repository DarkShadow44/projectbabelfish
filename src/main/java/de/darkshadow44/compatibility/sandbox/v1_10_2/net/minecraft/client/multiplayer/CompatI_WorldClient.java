package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.multiplayer;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world.CompatI_World;
import net.minecraft.client.multiplayer.WorldClient;

public interface CompatI_WorldClient extends CompatI_World {
	public WorldClient get();
}
