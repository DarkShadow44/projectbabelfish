package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.material.Compat_Material;
import net.minecraft.block.BlockSlab;

public class Compat_BlockSlab extends Compat_Block {
	private CompatI_BlockSlab wrapper;

	// When called from Mod
	public Compat_BlockSlab(boolean p1, Compat_Material material) { // TODO
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockSlab.class, this, material.getReal()));
	}

	// When called from child
	protected Compat_BlockSlab(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockSlab(BlockSlab original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockSlab.class, original));
	}

	protected void initialize(CompatI_BlockSlab wrapper) {
		this.wrapper = wrapper;
	}

	public BlockSlab getReal() {
		return wrapper.get();
	}

	public boolean isDouble() {
		return false; // TODO
	}

	public String getUnlocalizedName(int meta) {
		return this.wrapper.getUnlocalizedNameSuper();
	}
}
