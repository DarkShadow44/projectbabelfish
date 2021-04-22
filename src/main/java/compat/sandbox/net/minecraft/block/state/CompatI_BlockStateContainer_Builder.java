package compat.sandbox.net.minecraft.block.state;

import net.minecraft.state.IProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.world.chunk.BlockStateContainer;

public interface CompatI_BlockStateContainer_Builder {
	public Builder get();

	public Builder addSuper(IProperty<?>[] propertiesConverted);

	public BlockStateContainer buildSuper();
}
