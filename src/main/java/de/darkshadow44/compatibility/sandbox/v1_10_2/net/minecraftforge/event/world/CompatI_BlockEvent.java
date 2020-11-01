package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.event.world;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.eventhandler.CompatI_Event;
import net.minecraftforge.event.world.BlockEvent;

public interface CompatI_BlockEvent extends CompatI_Event {
	public BlockEvent get();
}
