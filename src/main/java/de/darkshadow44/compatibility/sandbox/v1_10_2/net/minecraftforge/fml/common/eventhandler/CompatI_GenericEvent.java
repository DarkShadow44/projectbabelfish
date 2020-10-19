package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.eventhandler;

import net.minecraftforge.fml.common.eventhandler.GenericEvent;

public interface CompatI_GenericEvent<T> extends CompatI_Event {
	public GenericEvent<T> get();
}
