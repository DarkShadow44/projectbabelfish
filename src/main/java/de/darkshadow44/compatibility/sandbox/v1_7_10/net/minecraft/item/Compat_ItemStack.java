package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class Compat_ItemStack extends ItemStack {

	public Compat_ItemStack(Block blockIn) {
		super(blockIn);
	}

}
