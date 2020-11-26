package compat.sandbox.net.minecraft.item;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.block.Compat_Block;
import net.minecraft.item.ItemSeeds;

public class Compat_ItemSeeds extends Compat_Item {
	private CompatI_ItemSeeds wrapper;

	// When called from Mod
	public Compat_ItemSeeds(Compat_Block b1, Compat_Block b2) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ItemSeeds.class, this, b1.getReal(), b2.getReal()));
	}

	// When called from child
	protected Compat_ItemSeeds(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ItemSeeds(ItemSeeds original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_ItemSeeds.class, original));
	}

	protected void initialize(CompatI_ItemSeeds wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public ItemSeeds getReal() {
		return wrapper.get();
	}
}
