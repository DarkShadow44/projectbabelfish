package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemColored;

public class CompatReal_ItemColored extends ItemColored implements CompatI_ItemColored {
	@SuppressWarnings("unused")
	private Compat_ItemColored thisFake;

	public CompatReal_ItemColored(Compat_ItemColored thisFake, Block block, boolean p1) {
		super(block, p1);
		this.thisFake = thisFake;
	}

	@Override
	public ItemColored get() {
		return this;
	}
}
