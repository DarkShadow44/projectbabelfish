package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fluids;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.CompatI_Block;
import net.minecraftforge.fluids.BlockFluidBase;

public interface CompatI_BlockFluidBase extends CompatI_Block {
	public BlockFluidBase get();

	public BlockFluidBase setQuantaPerBlockSuper(int value);
}
