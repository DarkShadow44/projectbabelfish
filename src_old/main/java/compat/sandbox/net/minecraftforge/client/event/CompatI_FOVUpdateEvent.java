package compat.sandbox.net.minecraftforge.client.event;

import compat.sandbox.net.minecraftforge.fml.common.eventhandler.CompatI_Event;
import net.minecraftforge.client.event.FOVUpdateEvent;

public interface CompatI_FOVUpdateEvent extends CompatI_Event {
	public FOVUpdateEvent get();
}
