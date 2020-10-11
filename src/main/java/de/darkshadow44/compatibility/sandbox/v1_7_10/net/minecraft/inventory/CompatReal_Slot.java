package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class CompatReal_Slot extends Slot implements CompatI_Slot {
	@SuppressWarnings("unused")
	private Compat_Slot thisFake;

	public CompatReal_Slot(Compat_Slot thisFake, IInventory inventory, int index, int x, int y) {
		super(inventory, index, x, y);
		this.thisFake = thisFake;
	}

	@Override
	public Slot get() {
		return this;
	}
}
