package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.tileentity;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class Compat_TileEntitySpecialRenderer<T extends TileEntity> {
	private CompatI_TileEntitySpecialRenderer<T> wrapper;

	// When called from Mod
	public Compat_TileEntitySpecialRenderer() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_TileEntitySpecialRenderer.class, this));
	}

	// When called from child
	protected Compat_TileEntitySpecialRenderer(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_TileEntitySpecialRenderer(TileEntitySpecialRenderer<T> original) {
		this.initialize(Factory.createWrapper(CompatI_TileEntitySpecialRenderer.class, original));
	}

	protected void initialize(CompatI_TileEntitySpecialRenderer<T> wrapper) {
		this.wrapper = wrapper;
	}

	public TileEntitySpecialRenderer<T> getReal() {
		return wrapper.get();
	}
}
