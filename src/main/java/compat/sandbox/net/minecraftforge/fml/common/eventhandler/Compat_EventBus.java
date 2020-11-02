package compat.sandbox.net.minecraftforge.fml.common.eventhandler;

import compat.core.CompatibilityMod;
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
		CompatibilityMod.LAYER_1_10_2.getModById(CompatibilityMod.LAYER_1_10_2.currentModId).addEventObject(obj);
	}

	public boolean Compat_post(Compat_Event event) {
		return original.post(event.getReal());
	}
}
