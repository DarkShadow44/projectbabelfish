package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.gui.inventory;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;

public abstract class Compat_GuiContainer extends GuiContainer {

	public Compat_GuiContainer(Container inventorySlotsIn) {
		super(inventorySlotsIn);
	}

}
