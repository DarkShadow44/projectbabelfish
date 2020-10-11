package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.tileentity;

import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.tileentity.TileEntityChest;

public class Compat_TileEntityChest extends Compat_TileEntity {
	private TileEntityChest original;
	private CompatI_TileEntityChest thisReal;

	// When called from Mod
	public Compat_TileEntityChest() {
		super(ParentSelector.NULL);
		super.initialize(new CompatReal_TileEntityChest(this), null);
	}

	// When called from child
	protected Compat_TileEntityChest(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_TileEntityChest(TileEntityChest original) {
		super(ParentSelector.NULL);
		super.initialize(null, original);
	}

	protected void initialize(CompatI_TileEntityChest thisReal, TileEntityChest original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public TileEntityChest getReal() {
		return original == null ? thisReal.get() : original;
	}
}
