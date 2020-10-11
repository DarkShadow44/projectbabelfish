package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.Compat_Block;
import net.minecraft.item.ItemBlock;

public class Compat_ItemBlock extends Compat_Item {
	private ItemBlock original;
	private CompatI_ItemBlock thisReal;

	// When called from Mod
	public Compat_ItemBlock(Compat_Block block) {
		super(ParentSelector.NULL);
		this.initialize(new CompatReal_ItemBlock(this, block.getReal()), null);
	}

	// When called from child
	protected Compat_ItemBlock(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ItemBlock(ItemBlock original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_ItemBlock thisReal, ItemBlock original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public ItemBlock getReal() {
		return original == null ? thisReal.get() : original;
	}
}
