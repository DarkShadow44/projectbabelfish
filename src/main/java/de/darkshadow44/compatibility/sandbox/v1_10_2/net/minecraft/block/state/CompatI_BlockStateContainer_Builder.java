package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.BlockStateContainer.Builder;
import net.minecraftforge.common.property.IUnlistedProperty;

public interface CompatI_BlockStateContainer_Builder {
	public Builder get();

	public Builder addSuper(IProperty<?>[] propertiesConverted);

	public Builder addSuper(IUnlistedProperty<?>[] propertiesConverted);

	public BlockStateContainer buildSuper();
}
