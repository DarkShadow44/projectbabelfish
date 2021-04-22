package compat.sandbox.net.minecraftforge.event.entity.player;

import net.minecraftforge.event.entity.player.PlayerInteractEvent.LeftClickBlock;
import net.minecraftforge.eventbus.api.Event.Result;

public interface CompatI_PlayerInteractEvent_LeftClickBlock extends CompatI_PlayerInteractEvent {
	public LeftClickBlock get();

	public void setUseItemSuper(Result result);

	public void setUseBlockSuper(Result result);
}
