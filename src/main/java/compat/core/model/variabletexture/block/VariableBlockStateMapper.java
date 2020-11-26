package compat.core.model.variabletexture.block;

import java.util.HashMap;
import java.util.Map;

import compat.core.model.variabletexture.item.ModelItemVariableTexture;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.IStateMapper;

public class VariableBlockStateMapper implements IStateMapper {

	@Override
	public Map<IBlockState, ModelResourceLocation> putStateModelLocations(Block arg0) {
		Map<IBlockState, ModelResourceLocation> ret = new HashMap<>();

		ret.put(arg0.getDefaultState(), ModelItemVariableTexture.LOCATION);

		return ret;
	}

}
