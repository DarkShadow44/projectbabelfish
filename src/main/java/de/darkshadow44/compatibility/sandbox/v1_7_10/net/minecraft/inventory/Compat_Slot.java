package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class Compat_Slot extends Slot {

	public Compat_Slot(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}

}
