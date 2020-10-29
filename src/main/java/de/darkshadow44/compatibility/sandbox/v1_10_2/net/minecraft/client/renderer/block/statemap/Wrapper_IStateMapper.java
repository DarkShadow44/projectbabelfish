package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.statemap;

import java.util.HashMap;
import java.util.Map;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.Compat_Block;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state.Compat_IBlockState;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.model.Compat_ModelResourceLocation;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.IStateMapper;

public class Wrapper_IStateMapper implements IStateMapper {

	private final Compat_IStateMapper fake;

	public Wrapper_IStateMapper(Compat_IStateMapper fake) {
		this.fake = fake;
	}

	@Override
	public Map<IBlockState, ModelResourceLocation> putStateModelLocations(Block block) {
		Map<Compat_IBlockState, Compat_ModelResourceLocation> results = fake.Compat_func_178130_a(new Compat_Block(block));

		Map<IBlockState, ModelResourceLocation> ret = new HashMap<>();

		for (Compat_IBlockState state : results.keySet()) {
			Compat_ModelResourceLocation location = results.get(state);
			ret.put(state.getReal(), location.getReal());
		}

		return ret;
	}
}
