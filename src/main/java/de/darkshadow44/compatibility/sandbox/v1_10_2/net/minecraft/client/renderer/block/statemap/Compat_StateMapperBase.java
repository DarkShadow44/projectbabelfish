package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.statemap;

import java.util.HashMap;
import java.util.Map;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.Compat_Block;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state.Compat_IBlockState;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state.Wrapper_IBlockState;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.model.Compat_ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;

public class Compat_StateMapperBase implements Compat_IStateMapper {
	private StateMapperBase original;
	private CompatI_StateMapperBase thisReal;

	// When called from Mod
	public Compat_StateMapperBase() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_StateMapperBase.class, this), null);
	}

	// When called from child
	protected Compat_StateMapperBase(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_StateMapperBase(StateMapperBase original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_StateMapperBase thisReal, StateMapperBase original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public StateMapperBase getReal() {
		return original == null ? thisReal.get() : original;
	}

	@Override
	public Map<Compat_IBlockState, Compat_ModelResourceLocation> func_178130_a(Compat_Block block) {
		Map<IBlockState, ModelResourceLocation> results;
		if (original == null)
			results = thisReal.putStateModelLocationsSuper(block.getReal());
		else
			results = original.putStateModelLocations(block.getReal());

		Map<Compat_IBlockState, Compat_ModelResourceLocation> ret = new HashMap<>();

		for (IBlockState state : results.keySet()) {
			ModelResourceLocation location = results.get(state);
			ret.put(new Wrapper_IBlockState(state), new Compat_ModelResourceLocation(location));
		}

		return ret;
	}
}
