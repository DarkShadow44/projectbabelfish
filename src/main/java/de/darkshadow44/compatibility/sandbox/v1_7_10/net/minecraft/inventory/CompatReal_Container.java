package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class CompatReal_Container extends Container implements CompatI_Container {
	@SuppressWarnings("unused")
	private Compat_Container thisFake;

	public CompatReal_Container(Compat_Container thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public Container get() {
		return this;
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		// TODO
		return false;
	}
}
