package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.tileentity;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public interface CompatI_TileEntitySpecialRenderer<T extends TileEntity> {
	public TileEntitySpecialRenderer<T> get();
}
