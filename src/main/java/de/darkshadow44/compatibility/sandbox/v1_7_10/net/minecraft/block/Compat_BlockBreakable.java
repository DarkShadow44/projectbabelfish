package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.material.Compat_Material;
import net.minecraft.block.BlockBreakable;

public class Compat_BlockBreakable extends Compat_Block {
	private CompatI_BlockBreakable wrapper;

	// When called from Mod
	public Compat_BlockBreakable(String p0, Compat_Material material, boolean p1) { // TODO
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockBreakable.class, this, material.getReal(), p1));
	}

	// When called from child
	protected Compat_BlockBreakable(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockBreakable(BlockBreakable original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockBreakable.class, original));
	}

	protected void initialize(CompatI_BlockBreakable wrapper) {
		this.wrapper = wrapper;
	}

	public BlockBreakable getReal() {
		return wrapper.get();
	}
}
