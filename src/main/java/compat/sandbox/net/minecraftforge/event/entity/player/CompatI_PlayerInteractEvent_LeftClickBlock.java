package compat.sandbox.net.minecraftforge.event.entity.player;

import net.minecraftforge.event.entity.player.PlayerInteractEvent.LeftClickBlock;

public interface CompatI_PlayerInteractEvent_LeftClickBlock extends CompatI_PlayerInteractEvent {
	public LeftClickBlock get();
}
