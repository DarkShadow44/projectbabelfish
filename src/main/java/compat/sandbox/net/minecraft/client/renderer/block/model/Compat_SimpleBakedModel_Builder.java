package compat.sandbox.net.minecraft.client.renderer.block.model;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.block.state.Compat_IBlockState;
import compat.sandbox.net.minecraft.client.renderer.texture.Compat_TextureAtlasSprite;
import compat.sandbox.net.minecraft.util.math.Compat_BlockPos;
import net.minecraft.client.renderer.model.SimpleBakedModel.Builder;

public class Compat_SimpleBakedModel_Builder {
	private CompatI_SimpleBakedModel_Builder wrapper;

	// When called from Mod
	public Compat_SimpleBakedModel_Builder(Compat_IBlockState state, Compat_IBakedModel model, Compat_TextureAtlasSprite tex, Compat_BlockPos pos) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_SimpleBakedModel_Builder.class, this, state.getReal(), Compat_IBakedModel.getReal(model), tex.getReal(), pos.getReal()));
	}

	// When called from child
	protected Compat_SimpleBakedModel_Builder(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_SimpleBakedModel_Builder(Builder original) {
		this.initialize(Factory.createWrapper(CompatI_SimpleBakedModel_Builder.class, original));
	}

	protected void initialize(CompatI_SimpleBakedModel_Builder wrapper) {
		this.wrapper = wrapper;
	}

	public Builder getReal() {
		return wrapper.get();
	}

	public Compat_IBakedModel Compat_func_177645_b() {
		return new Wrapper2_IBakedModel(wrapper.makeBakedModelSuper());
	}
}
