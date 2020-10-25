package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.tileentity;

import de.darkshadow44.compatibility.autogen.Callback;
import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.tileentity.Compat_TileEntity;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class Compat_TileEntitySpecialRenderer<T extends Compat_TileEntity> {
	private TileEntitySpecialRenderer<TileEntity> original;
	private CompatI_TileEntitySpecialRenderer<T> thisReal;

	// When called from Mod
	public Compat_TileEntitySpecialRenderer() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_TileEntitySpecialRenderer.class, this), null);
	}

	// When called from child
	protected Compat_TileEntitySpecialRenderer(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_TileEntitySpecialRenderer(TileEntitySpecialRenderer<TileEntity> original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_TileEntitySpecialRenderer<T> thisReal, TileEntitySpecialRenderer<TileEntity> original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public TileEntitySpecialRenderer<TileEntity> getReal() {
		return original == null ? thisReal.get() : original;
	}

	@Callback
	public void render(TileEntity te, double x, double y, double z, float partialTicks, int destroyStage, float p1) {
		Compat_func_180535_a(Compat_TileEntity.get_fake(te), x, y, z, partialTicks, destroyStage);
	}

	public void Compat_func_180535_a(Compat_TileEntity te, double x, double y, double z, float partialTicks, int destroyStage) {
		if (original == null)
			thisReal.renderSuper(te.getReal(), x, y, z, partialTicks, destroyStage, 0);
		else
			original.render(te.getReal(), x, y, z, partialTicks, destroyStage, 0);
	}

	public Compat_TileEntityRendererDispatcher Compat_get_field_147501_a()
	{
		if (original == null)
			return new Compat_TileEntityRendererDispatcher(thisReal.get_rendererDispatcher());
		else
			throw new RuntimeException();
	}
}
