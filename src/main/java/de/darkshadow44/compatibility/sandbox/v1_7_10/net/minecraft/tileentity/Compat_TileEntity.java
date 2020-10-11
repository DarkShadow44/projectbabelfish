package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.tileentity;

import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.tileentity.TileEntity;

public class Compat_TileEntity {
	private TileEntity original;
	private CompatI_TileEntity thisReal;

	// When called from Mod
	public Compat_TileEntity() {
		initialize(new CompatReal_TileEntity(this), null);
	}

	// When called from child
	protected Compat_TileEntity(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_TileEntity(TileEntity original) {
		initialize(null, original);
	}

	protected void initialize(CompatI_TileEntity thisReal, TileEntity original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public TileEntity getReal() {
		return original == null ? thisReal.get() : original;
	}
}
