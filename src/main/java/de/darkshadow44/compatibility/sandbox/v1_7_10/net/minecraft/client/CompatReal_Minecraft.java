package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client;

import net.minecraft.client.Minecraft;

public class CompatReal_Minecraft extends Minecraft implements CompatI_Minecraft {
	@SuppressWarnings("unused")
	private Compat_Minecraft thisFake;

	public CompatReal_Minecraft(Compat_Minecraft thisFake) {
		super(null); // TODO
		this.thisFake = thisFake;
	}

	@Override
	public Minecraft get() {
		return this;
	}
}
