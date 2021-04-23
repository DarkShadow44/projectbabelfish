package compat.core.model.variabletexture.block;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.IStateMapper;

public class VariableBlockStateMapper implements IStateMapper {

	@Override
	public Map<IBlockState, ModelResourceLocation> putStateModelLocations(Block block) {
		Map<IBlockState, ModelResourceLocation> ret = new HashMap<>();

		for (IBlockState state : block.getBlockState().getValidStates()) {
			ret.put(state, ModelBlockVariableTexture.LOCATION);
		}

		return ret;
	}

}
