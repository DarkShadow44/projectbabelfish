package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.gui.inventory;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;

public class CompatReal_GuiContainer extends GuiContainer implements CompatI_GuiContainer {
	@SuppressWarnings("unused")
	private Compat_GuiContainer thisFake;

	public CompatReal_GuiContainer(Compat_GuiContainer thisFake, Container container) {
		super(container);
		this.thisFake = thisFake;
	}

	@Override
	public GuiContainer get() {
		return this;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		// TODO
	}
}
