package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.eventhandler;

import net.minecraftforge.fml.common.eventhandler.EventBus;

public class Compat_EventBus {

	private final EventBus original;

	public Compat_EventBus(EventBus original) {
		this.original = original;
	}

	public EventBus getReal() {
		return original;
	}

	public void Compat_register(Object obj) {
		// TODO
	}

	public boolean Compat_post(Compat_Event event) {
		return original.post(event.getReal());
	}
}
