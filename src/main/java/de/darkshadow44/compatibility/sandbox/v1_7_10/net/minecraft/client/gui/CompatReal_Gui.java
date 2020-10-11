package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.gui;

import net.minecraft.client.gui.Gui;

public class CompatReal_Gui extends Gui implements CompatI_Gui {
	@SuppressWarnings("unused")
	private Compat_Gui thisFake;

	public CompatReal_Gui(Compat_Gui thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public Gui get() {
		return this;
	}
}
