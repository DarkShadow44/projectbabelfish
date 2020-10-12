package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.tileentity;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class Compat_TileEntitySpecialRenderer<T extends TileEntity> {
	private TileEntitySpecialRenderer<T> original;
	private CompatI_TileEntitySpecialRenderer<T> thisReal;

	// When called from Mod
	public Compat_TileEntitySpecialRenderer() {
		this.initialize(Factory.create(CtorPos.POS1, this), null);
	}

	// When called from child
	protected Compat_TileEntitySpecialRenderer(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_TileEntitySpecialRenderer(TileEntitySpecialRenderer<T> original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_TileEntitySpecialRenderer<T> thisReal, TileEntitySpecialRenderer<T> original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public TileEntitySpecialRenderer<T> getReal() {
		return original == null ? thisReal.get() : original;
	}
}
