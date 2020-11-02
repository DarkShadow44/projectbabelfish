package compat.sandbox.net.minecraft.item;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.block.Compat_Block;
import net.minecraft.item.ItemColored;

public class Compat_ItemColored extends Compat_ItemBlock {
	private CompatI_ItemColored wrapper;

	// When called from Mod
	public Compat_ItemColored(Compat_Block block, boolean p1) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ItemColored.class, this, block.getReal(), p1));
	}

	// When called from child
	protected Compat_ItemColored(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ItemColored(ItemColored original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_ItemColored.class, original));
	}

	protected void initialize(CompatI_ItemColored wrapper) {
		this.wrapper = wrapper;
	}

	public ItemColored getReal() {
		return wrapper.get();
	}
}
