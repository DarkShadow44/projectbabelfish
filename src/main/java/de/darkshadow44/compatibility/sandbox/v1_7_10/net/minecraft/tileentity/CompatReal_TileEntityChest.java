package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.tileentity;

import net.minecraft.tileentity.TileEntityChest;

public class CompatReal_TileEntityChest extends TileEntityChest implements CompatI_TileEntityChest {
	@SuppressWarnings("unused")
	private Compat_TileEntityChest thisFake;

	public CompatReal_TileEntityChest(Compat_TileEntityChest thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public TileEntityChest get() {
		return this;
	}
}
