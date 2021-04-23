package compat.sandbox.net.minecraftforge.event.entity;

import compat.sandbox.net.minecraftforge.fml.common.eventhandler.CompatI_Event;
import net.minecraftforge.event.entity.EntityEvent;

public interface CompatI_EntityEvent extends CompatI_Event {
	public EntityEvent get();
}
