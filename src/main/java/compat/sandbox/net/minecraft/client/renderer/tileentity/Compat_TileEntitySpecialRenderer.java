package compat.sandbox.net.minecraft.client.renderer.tileentity;

import compat.autogen.Callback;
import compat.autogen.Factory;
import compat.autogen.HasCallback;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.tileentity.Compat_TileEntity;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class Compat_TileEntitySpecialRenderer<T extends Compat_TileEntity> {
	private CompatI_TileEntitySpecialRenderer<T> wrapper;

	// When called from Mod
	public Compat_TileEntitySpecialRenderer() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_TileEntitySpecialRenderer.class, this));
	}

	// When called from child
	protected Compat_TileEntitySpecialRenderer(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_TileEntitySpecialRenderer(TileEntitySpecialRenderer<TileEntity> original) {
		this.initialize(Factory.createWrapper(CompatI_TileEntitySpecialRenderer.class, original));
	}

	protected void initialize(CompatI_TileEntitySpecialRenderer<T> wrapper) {
		this.wrapper = wrapper;
	}

	public TileEntitySpecialRenderer<TileEntity> getReal() {
		return wrapper.get();
	}

	@Callback
	public void render(TileEntity te, double x, double y, double z, float partialTicks, int destroyStage, float p1) {
		Compat_func_180535_a(Compat_TileEntity.get_fake(te), x, y, z, partialTicks, destroyStage);
	}

	@HasCallback
	public void Compat_func_180535_a(Compat_TileEntity te, double x, double y, double z, float partialTicks, int destroyStage) {
		wrapper.renderSuper(te.getReal(), x, y, z, partialTicks, destroyStage, 0);
	}

	public Compat_TileEntityRendererDispatcher Compat_get_field_147501_a() {
		return new Compat_TileEntityRendererDispatcher(wrapper.get_rendererDispatcher());
	}
}
