package compat.sandbox.net.minecraft.tileentity;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.tileentity.TileEntityChest;

public class Compat_TileEntityChest extends Compat_TileEntity {
	private CompatI_TileEntityChest wrapper;

	// When called from Mod
	public Compat_TileEntityChest() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_TileEntityChest.class, this));
	}

	// When called from child
	protected Compat_TileEntityChest(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_TileEntityChest(TileEntityChest original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_TileEntityChest.class, original));
	}

	protected void initialize(CompatI_TileEntityChest wrapper) {
		this.wrapper = wrapper;
	}

	public TileEntityChest getReal() {
		return wrapper.get();
	}
}
