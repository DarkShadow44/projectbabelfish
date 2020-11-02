package compat.sandbox.net.minecraft.item;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.block.Compat_Block;
import net.minecraft.item.ItemBlock;

public class Compat_ItemBlock extends Compat_Item {
	private CompatI_ItemBlock wrapper;

	// When called from Mod
	public Compat_ItemBlock(Compat_Block block) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ItemBlock.class, this, block.getReal()));
	}

	// When called from child
	protected Compat_ItemBlock(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ItemBlock(ItemBlock original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_ItemBlock.class, original));
	}

	protected void initialize(CompatI_ItemBlock wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public ItemBlock getReal() {
		return wrapper.get();
	}
	
	public Compat_ItemBlock Compat_func_77655_b(String unlocalizedName) {
		// TODO move up?
		wrapper.setUnlocalizedNameSuper(unlocalizedName);
		return this;
	}
}
