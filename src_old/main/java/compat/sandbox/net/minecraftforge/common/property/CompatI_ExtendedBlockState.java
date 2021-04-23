package compat.sandbox.net.minecraftforge.common.property;

import compat.sandbox.net.minecraft.block.state.CompatI_BlockStateContainer;
import net.minecraftforge.common.property.ExtendedBlockState;

public interface CompatI_ExtendedBlockState extends CompatI_BlockStateContainer {
	public ExtendedBlockState get();
}
