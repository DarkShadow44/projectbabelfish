package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.gameevent;

import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

public class Compat_TickEvent_ClientTickEvent {

	private final ClientTickEvent original;

	public Compat_TickEvent_ClientTickEvent(ClientTickEvent original) {
		this.original = original;
	}

	public ClientTickEvent getReal() {
		return original;
	}
}
