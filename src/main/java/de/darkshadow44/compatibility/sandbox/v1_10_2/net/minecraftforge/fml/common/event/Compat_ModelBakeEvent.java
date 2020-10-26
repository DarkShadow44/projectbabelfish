package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.event;

import net.minecraftforge.client.event.ModelBakeEvent;

public class Compat_ModelBakeEvent {

	private final ModelBakeEvent original;

	public Compat_ModelBakeEvent(ModelBakeEvent original) {
		this.original = original;
	}

	public ModelBakeEvent getReal() {
		return original;
	}
}
