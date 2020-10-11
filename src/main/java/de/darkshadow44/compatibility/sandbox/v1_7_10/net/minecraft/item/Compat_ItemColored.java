package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.Compat_Block;
import net.minecraft.item.ItemColored;

public class Compat_ItemColored extends Compat_ItemBlock {
	private ItemColored original;
	private CompatI_ItemColored thisReal;

	// When called from Mod
	public Compat_ItemColored(Compat_Block block, boolean p1) {
		super(ParentSelector.NULL);
		this.initialize(new CompatReal_ItemColored(this, block.getReal(), p1), null);
	}

	// When called from child
	protected Compat_ItemColored(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ItemColored(ItemColored original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_ItemColored thisReal, ItemColored original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public ItemColored getReal() {
		return original == null ? thisReal.get() : original;
	}
}
