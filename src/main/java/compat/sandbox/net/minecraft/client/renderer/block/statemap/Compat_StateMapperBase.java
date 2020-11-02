package compat.sandbox.net.minecraft.client.renderer.block.statemap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import compat.autogen.Callback;
import compat.autogen.Factory;
import compat.autogen.HasCallback;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.block.Compat_Block;
import compat.sandbox.net.minecraft.block.properties.Compat_IProperty;
import compat.sandbox.net.minecraft.block.state.Compat_IBlockState;
import compat.sandbox.net.minecraft.block.state.Wrapper_IBlockState;
import compat.sandbox.net.minecraft.client.renderer.block.model.Compat_ModelResourceLocation;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;

public class Compat_StateMapperBase implements Compat_IStateMapper {
	private CompatI_StateMapperBase wrapper;

	// When called from Mod
	public Compat_StateMapperBase() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_StateMapperBase.class, this));
	}

	// When called from child
	protected Compat_StateMapperBase(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_StateMapperBase(StateMapperBase original) {
		this.initialize(Factory.createWrapper(CompatI_StateMapperBase.class, original));
	}

	protected void initialize(CompatI_StateMapperBase wrapper) {
		this.wrapper = wrapper;
	}

	public StateMapperBase getReal() {
		return wrapper.get();
	}

	@Callback
	public Map<IBlockState, ModelResourceLocation> putStateModelLocations(Block block) {
		Map<Compat_IBlockState, Compat_ModelResourceLocation> map = Compat_func_178130_a(new Compat_Block(block));
		Map<IBlockState, ModelResourceLocation> ret = new HashMap<>();

		for (Entry<Compat_IBlockState, Compat_ModelResourceLocation> entry : map.entrySet()) {
			ret.put(entry.getKey().getReal(), entry.getValue().getReal());
		}

		return ret;
	}

	@Override
	@HasCallback
	public Map<Compat_IBlockState, Compat_ModelResourceLocation> Compat_func_178130_a(Compat_Block block) {
		Map<IBlockState, ModelResourceLocation> result = wrapper.putStateModelLocationsSuper(block.getReal());

		Map<Compat_IBlockState, Compat_ModelResourceLocation> ret = new HashMap<>();

		for (Entry<IBlockState, ModelResourceLocation> entry : result.entrySet()) {
			ret.put(new Wrapper_IBlockState(entry.getKey()), new Compat_ModelResourceLocation(entry.getValue()));
		}

		return ret;
	}

	public String Compat_func_178131_a(Map<Compat_IProperty<?>, Comparable<?>> map) {
		Map<IProperty<?>, Comparable<?>> map2 = new LinkedHashMap<>();

		for (Entry<Compat_IProperty<?>, Comparable<?>> property : map.entrySet()) {
			map2.put(property.getKey().getReal(), property.getValue());
		}

		return wrapper.getPropertyStringSuper(map2);
	}
}
