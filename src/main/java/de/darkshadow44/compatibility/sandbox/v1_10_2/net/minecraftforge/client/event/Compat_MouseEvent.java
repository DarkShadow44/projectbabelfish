package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.client.event;

import net.minecraftforge.client.event.MouseEvent;

public class Compat_MouseEvent {
	private final MouseEvent original;

	public Compat_MouseEvent(MouseEvent original) {
		this.original = original;
	}

	public MouseEvent getReal() {
		return original;
	}
}
