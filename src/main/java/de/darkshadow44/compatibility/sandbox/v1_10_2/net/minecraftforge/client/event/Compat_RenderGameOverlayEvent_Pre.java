package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.client.event;

import net.minecraftforge.client.event.RenderGameOverlayEvent.Pre;

public class Compat_RenderGameOverlayEvent_Pre {
	private final Pre original;

	public Compat_RenderGameOverlayEvent_Pre(Pre original) {
		this.original = original;
	}

	public Pre getReal() {
		return original;
	}
}
