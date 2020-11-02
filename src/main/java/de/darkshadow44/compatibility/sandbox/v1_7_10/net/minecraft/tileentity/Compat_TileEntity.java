package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.tileentity;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.tileentity.TileEntity;

public class Compat_TileEntity {
	private CompatI_TileEntity wrapper;

	// When called from Mod
	public Compat_TileEntity() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_TileEntity.class, this));
	}

	// When called from child
	protected Compat_TileEntity(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_TileEntity(TileEntity original) {
		this.initialize(Factory.createWrapper(CompatI_TileEntity.class, original));
	}

	protected void initialize(CompatI_TileEntity wrapper) {
		this.wrapper = wrapper;
	}

	public TileEntity getReal() {
		return wrapper.get();
	}
}
