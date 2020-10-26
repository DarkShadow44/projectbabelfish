package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.gameevent;

import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Compat_TickEvent_ClientTickEvent {

	private final TickEvent original;

	public Compat_TickEvent_ClientTickEvent(TickEvent original) {
		this.original = original;
	}

	public TickEvent getReal() {
		return original;
	}
}
