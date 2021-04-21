package compat.sandbox.net.minecraft.client.renderer.tileentity;

import compat.sandbox.net.minecraft.tileentity.Compat_TileEntity;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.tileentity.TileEntity;

public interface CompatI_TileEntitySpecialRenderer<T extends Compat_TileEntity> {
	public TileEntityRenderer<TileEntity> get();

	public void renderSuper(TileEntity te, double x, double y, double z, float partialTicks, int destroyStage, float p1);

	public TileEntityRendererDispatcher get_rendererDispatcher();
}
