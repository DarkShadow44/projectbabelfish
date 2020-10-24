package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.tileentity;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.tileentity.Compat_TileEntity;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public interface CompatI_TileEntitySpecialRenderer<T extends Compat_TileEntity> {
	public TileEntitySpecialRenderer<TileEntity> get();
}
