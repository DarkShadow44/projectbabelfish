package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.gui;

import net.minecraft.client.gui.GuiScreen;

public class CompatReal_GuiScreen extends GuiScreen implements CompatI_GuiScreen {
	@SuppressWarnings("unused")
	private Compat_GuiScreen thisFake;

	public CompatReal_GuiScreen(Compat_GuiScreen thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public GuiScreen get() {
		return this;
	}
}
