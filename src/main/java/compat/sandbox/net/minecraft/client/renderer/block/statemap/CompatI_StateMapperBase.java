package compat.sandbox.net.minecraft.client.renderer.block.statemap;

import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.state.IProperty;

public interface CompatI_StateMapperBase {
	public StateMapperBase get();

	public Map<IBlockState, ModelResourceLocation> putStateModelLocationsSuper(Block block);

	public String getPropertyStringSuper(Map<IProperty<?>, Comparable<?>> map2);
}
