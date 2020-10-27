package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.event;

import net.minecraftforge.event.AttachCapabilitiesEvent;

public interface CompatI_AttachCapabilitiesEvent_TileEntity<T> extends CompatI_AttachCapabilitiesEvent<T> {
	public AttachCapabilitiesEvent<T> get();
}
