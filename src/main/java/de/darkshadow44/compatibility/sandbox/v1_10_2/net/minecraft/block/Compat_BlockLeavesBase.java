package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.material.Compat_Material;
import net.minecraft.block.Block;

public class Compat_BlockLeavesBase extends Compat_Block {
	private CompatI_BlockLeavesBase wrapper;

	// When called from Mod
	public Compat_BlockLeavesBase(Compat_Material material, boolean p1) { // TODO
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockLeavesBase.class, this, material.getReal()));
	}

	// When called from child
	protected Compat_BlockLeavesBase(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockLeavesBase(Block original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockLeavesBase.class, original));
	}

	protected void initialize(CompatI_BlockLeavesBase wrapper) {
		this.wrapper = wrapper;
	}

	public Block getReal() {
		return wrapper.get();
	}
}
