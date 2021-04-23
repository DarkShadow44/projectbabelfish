package compat.sandbox.net.minecraftforge.client.event;

import compat.sandbox.net.minecraftforge.fml.common.eventhandler.CompatI_Event;
import net.minecraftforge.client.event.MouseEvent;

public interface CompatI_MouseEvent extends CompatI_Event {
	public MouseEvent get();

	public int getDwheelSuper();
}
