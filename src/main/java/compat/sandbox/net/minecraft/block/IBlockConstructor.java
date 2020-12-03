package compat.sandbox.net.minecraft.block;

import net.minecraft.block.Block;

public abstract interface IBlockConstructor {
	public abstract <R extends Block> Object construct(Block original);
}
