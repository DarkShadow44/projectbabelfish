package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class CompatReal_ItemSlab extends ItemSlab implements CompatI_ItemSlab {
	@SuppressWarnings("unused")
	private Compat_ItemSlab thisFake;

	public CompatReal_ItemSlab(Compat_ItemSlab thisFake, Block block, BlockSlab singleSlab, BlockSlab doubleSlab) {
		super(block, singleSlab, doubleSlab);
		this.thisFake = thisFake;
	}

	@Override
	public ItemSlab get() {
		return this;
	}
}
