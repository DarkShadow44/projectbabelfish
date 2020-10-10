package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;

public class CompatReal_BlockStairs extends BlockStairs implements CompatI_BlockStairs {
	@SuppressWarnings("unused")
	private Compat_BlockStairs thisFake;

	public CompatReal_BlockStairs(Compat_BlockStairs thisFake, IBlockState modelState) {
		super(modelState);
		this.thisFake = thisFake;
	}

	@Override
	public BlockStairs get() {
		return this;
	}
}
