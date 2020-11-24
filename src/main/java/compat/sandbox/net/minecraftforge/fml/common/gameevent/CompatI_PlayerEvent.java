package compat.sandbox.net.minecraftforge.fml.common.gameevent;

import compat.sandbox.net.minecraftforge.fml.common.eventhandler.CompatI_Event;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public interface CompatI_PlayerEvent extends CompatI_Event {
	public PlayerEvent get();
}
