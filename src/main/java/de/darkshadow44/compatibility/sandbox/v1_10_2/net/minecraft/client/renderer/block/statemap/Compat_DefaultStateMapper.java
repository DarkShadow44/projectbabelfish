package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.statemap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import de.darkshadow44.compatibility.autogen.Callback;
import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.Compat_Block;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.properties.Compat_IProperty;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state.Compat_IBlockState;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state.Wrapper_IBlockState;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.model.Compat_ModelResourceLocation;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.DefaultStateMapper;

public class Compat_DefaultStateMapper extends Compat_StateMapperBase {
	private DefaultStateMapper original;
	private CompatI_DefaultStateMapper thisReal;

	// When called from Mod
	public Compat_DefaultStateMapper() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_DefaultStateMapper.class, this), null);
	}

	// When called from child
	protected Compat_DefaultStateMapper(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_DefaultStateMapper(DefaultStateMapper original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_DefaultStateMapper thisReal, DefaultStateMapper original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public DefaultStateMapper getReal() {
		return original == null ? thisReal.get() : original;
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

	public Map<Compat_IBlockState, Compat_ModelResourceLocation> Compat_func_178130_a(Compat_Block block) {
		Map<IBlockState, ModelResourceLocation> map;
		if (original == null)
			throw new RuntimeException();
		else
			map = original.putStateModelLocations(block.getReal());

		Map<Compat_IBlockState, Compat_ModelResourceLocation> ret = new HashMap<>();

		for (Entry<IBlockState, ModelResourceLocation> entry : map.entrySet()) {
			ret.put(new Wrapper_IBlockState(entry.getKey()), new Compat_ModelResourceLocation(entry.getValue()));
		}

		return ret;
	}

	public String Compat_func_178131_a(Map<Compat_IProperty<?>, Comparable<?>> map) {
		Map<IProperty<?>, Comparable<?>> map2 = new HashMap<>();

		for (Entry<Compat_IProperty<?>, Comparable<?>> property : map.entrySet()) {
			map2.put(property.getKey().getReal(), property.getValue());
		}

		if (original == null)
			return thisReal.getPropertyStringSuper(map2);
		else
			return original.getPropertyString(map2);
	}
}
