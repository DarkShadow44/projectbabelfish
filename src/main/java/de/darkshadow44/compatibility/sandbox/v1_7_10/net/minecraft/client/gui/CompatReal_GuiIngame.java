package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;

public class CompatReal_GuiIngame extends GuiIngame implements CompatI_GuiIngame {
	@SuppressWarnings("unused")
	private Compat_GuiIngame thisFake;

	public CompatReal_GuiIngame(Compat_GuiIngame thisFake, Minecraft mc) {
		super(mc);
		this.thisFake = thisFake;
	}

	@Override
	public GuiIngame get() {
		return this;
	}
}
