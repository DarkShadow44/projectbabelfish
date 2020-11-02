package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.Compat_Block;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.Compat_BlockSlab;
import net.minecraft.item.ItemSlab;

public class Compat_ItemSlab extends Compat_ItemBlock {
	private CompatI_ItemSlab wrapper;

	// When called from Mod
	public Compat_ItemSlab(Compat_Block block, Compat_BlockSlab singleSlab, Compat_BlockSlab doubleSlab) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ItemSlab.class, this, block.getReal(), singleSlab.getReal(), doubleSlab.getReal()));
	}

	// When called from Mod
	public Compat_ItemSlab(Compat_Block block, Compat_BlockSlab singleSlab, Compat_BlockSlab doubleSlab, boolean p1) { // TODO
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ItemSlab.class, this, block.getReal(), singleSlab.getReal(), doubleSlab.getReal()));
	}

	// When called from child
	protected Compat_ItemSlab(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ItemSlab(ItemSlab original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_ItemSlab.class, original));
	}

	protected void initialize(CompatI_ItemSlab wrapper) {
		this.wrapper = wrapper;
	}

	public ItemSlab getReal() {
		return wrapper.get();
	}
}
