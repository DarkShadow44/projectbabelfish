package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.statemap;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state.Compat_IBlockState;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.model.Compat_ModelResourceLocation;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.DefaultStateMapper;

public class Compat_DefaultStateMapper extends Compat_StateMapperBase {
	private CompatI_DefaultStateMapper wrapper;

	// When called from Mod
	public Compat_DefaultStateMapper() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_DefaultStateMapper.class, this));
	}

	// When called from child
	protected Compat_DefaultStateMapper(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_DefaultStateMapper(DefaultStateMapper original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_DefaultStateMapper.class, original));
	}

	protected void initialize(CompatI_DefaultStateMapper wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public DefaultStateMapper getReal() {
		return wrapper.get();
	}

	public Compat_ModelResourceLocation Compat_func_178132_a(Compat_IBlockState state) {
		ModelResourceLocation result = wrapper.getModelResourceLocationSuper(state.getReal());
		return result == null ? null : new Compat_ModelResourceLocation(result);
	}

}
