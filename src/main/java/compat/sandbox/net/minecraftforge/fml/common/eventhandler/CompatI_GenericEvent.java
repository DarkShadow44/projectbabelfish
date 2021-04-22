package compat.sandbox.net.minecraftforge.fml.common.eventhandler;

import net.minecraftforge.eventbus.api.GenericEvent;

public interface CompatI_GenericEvent<T> extends CompatI_Event {
	public GenericEvent<T> get();
}
