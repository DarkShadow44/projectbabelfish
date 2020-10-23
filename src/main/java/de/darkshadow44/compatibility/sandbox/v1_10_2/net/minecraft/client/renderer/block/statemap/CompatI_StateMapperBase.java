package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.statemap;

import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;

public interface CompatI_StateMapperBase {
	public StateMapperBase get();

	public Map<IBlockState, ModelResourceLocation> putStateModelLocationsSuper(Block block);
}
