package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.client.event;

import net.minecraftforge.client.event.RenderGameOverlayEvent.Post;

public class Compat_RenderGameOverlayEvent_Post {
	private final Post original;

	public Compat_RenderGameOverlayEvent_Post(Post original) {
		this.original = original;
	}

	public Post getReal() {
		return original;
	}
}
