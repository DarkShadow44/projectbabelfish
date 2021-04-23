package compat.sandbox.net.minecraftforge.event.world;

import compat.sandbox.net.minecraftforge.fml.common.eventhandler.CompatI_Event;
import net.minecraftforge.event.world.BlockEvent;

public interface CompatI_BlockEvent extends CompatI_Event {
	public BlockEvent get();
}
