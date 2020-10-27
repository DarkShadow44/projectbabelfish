package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.client.event;

import net.minecraftforge.client.event.DrawBlockHighlightEvent;

public class Compat_DrawBlockHighlightEvent {

	private final DrawBlockHighlightEvent original;

	public Compat_DrawBlockHighlightEvent(DrawBlockHighlightEvent original) {
		this.original = original;
	}

	public DrawBlockHighlightEvent getReal() {
		return original;
	}

}
