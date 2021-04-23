package compat.sandbox.net.minecraftforge.fml.common.gameevent;

import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public interface CompatI_PlayerEvent_ItemCraftedEvent extends CompatI_PlayerEvent {
	public ItemCraftedEvent get();
}
