package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.BlockChest;

public class CompatReal_BlockChest extends BlockChest implements CompatI_BlockChest {
	@SuppressWarnings("unused")
	private Compat_BlockChest thisFake;

	public CompatReal_BlockChest(Compat_BlockChest thisFake, Type chestTypeIn) {
		super(chestTypeIn);
		this.thisFake = thisFake;
	}

	@Override
	public BlockChest get() {
		return this;
	}
}
