package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.client.event;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.eventhandler.CompatI_Event;
import net.minecraftforge.client.event.FOVUpdateEvent;

public interface CompatI_FOVUpdateEvent extends CompatI_Event {
	public FOVUpdateEvent get();
}
