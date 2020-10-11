package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.gui;

import net.minecraft.client.gui.GuiButton;

public class CompatReal_GuiButton extends GuiButton implements CompatI_GuiButton {
	@SuppressWarnings("unused")
	private Compat_GuiButton thisFake;

	public CompatReal_GuiButton(Compat_GuiButton thisFake, int buttonId, int x, int y, String buttonText) {
		super(buttonId, x, y, buttonText);
		this.thisFake = thisFake;
	}

	@Override
	public GuiButton get() {
		return this;
	}
}
