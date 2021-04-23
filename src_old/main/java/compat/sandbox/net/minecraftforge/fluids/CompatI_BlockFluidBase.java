package compat.sandbox.net.minecraftforge.fluids;

import compat.sandbox.net.minecraft.block.CompatI_Block;
import net.minecraftforge.fluids.BlockFluidBase;

public interface CompatI_BlockFluidBase extends CompatI_Block {
	public BlockFluidBase get();

	public BlockFluidBase setQuantaPerBlockSuper(int value);
}
