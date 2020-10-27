package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.event.entity.player;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.eventhandler.CompatI_Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public interface CompatI_PlayerInteractEvent extends CompatI_Event {
	public PlayerInteractEvent get();
}
