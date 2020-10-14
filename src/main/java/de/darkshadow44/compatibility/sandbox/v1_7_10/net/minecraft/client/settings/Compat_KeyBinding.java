package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.settings;

import net.minecraft.client.settings.KeyBinding;

public class Compat_KeyBinding {

	@SuppressWarnings("unused")
	private KeyBinding original;

	public Compat_KeyBinding(KeyBinding original) {
		this.original = original;
	}
}
