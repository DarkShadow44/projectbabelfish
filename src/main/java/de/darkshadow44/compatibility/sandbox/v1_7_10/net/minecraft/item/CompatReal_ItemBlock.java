package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class CompatReal_ItemBlock extends ItemBlock implements CompatI_ItemBlock {
	@SuppressWarnings("unused")
	private Compat_ItemBlock thisFake;

	public CompatReal_ItemBlock(Compat_ItemBlock thisFake, Block block) {
		super(block);
		this.thisFake = thisFake;
	}

	@Override
	public ItemBlock get() {
		return this;
	}
}
