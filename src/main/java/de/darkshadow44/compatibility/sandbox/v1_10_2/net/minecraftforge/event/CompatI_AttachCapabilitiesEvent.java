package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.event;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.eventhandler.CompatI_GenericEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;

public interface CompatI_AttachCapabilitiesEvent<T> extends CompatI_GenericEvent<T> {
	public AttachCapabilitiesEvent<T> get();
}
