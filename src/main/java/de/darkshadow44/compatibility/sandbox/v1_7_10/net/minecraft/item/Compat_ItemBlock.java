package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.Compat_Block;
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
		this.wrapper = wrapper;
	}

	public ItemBlock getReal() {
		return wrapper.get();
	}

	public Compat_ItemBlock Compat_func_77655_b(String unlocalizedName) {

		wrapper.setUnlocalizedNameSuper(unlocalizedName);
		return this;
	}
}
