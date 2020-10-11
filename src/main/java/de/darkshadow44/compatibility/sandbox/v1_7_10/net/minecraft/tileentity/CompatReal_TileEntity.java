package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.tileentity;

import net.minecraft.tileentity.TileEntity;

public class CompatReal_TileEntity extends TileEntity implements CompatI_TileEntity {
	@SuppressWarnings("unused")
	private Compat_TileEntity thisFake;

	public CompatReal_TileEntity(Compat_TileEntity thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public TileEntity get() {
		return this;
	}
}
