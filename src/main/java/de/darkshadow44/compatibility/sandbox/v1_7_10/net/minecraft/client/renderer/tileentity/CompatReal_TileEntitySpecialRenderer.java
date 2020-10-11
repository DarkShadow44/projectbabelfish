package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.tileentity;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class CompatReal_TileEntitySpecialRenderer<T extends TileEntity> extends TileEntitySpecialRenderer<T> implements CompatI_TileEntitySpecialRenderer<T> {
	@SuppressWarnings("unused")
	private Compat_TileEntitySpecialRenderer<T> thisFake;

	public CompatReal_TileEntitySpecialRenderer(Compat_TileEntitySpecialRenderer<T> thisFake) {
		super();
		this.thisFake = thisFake;
	}

	@Override
	public TileEntitySpecialRenderer<T> get() {
		return this;
	}
}
