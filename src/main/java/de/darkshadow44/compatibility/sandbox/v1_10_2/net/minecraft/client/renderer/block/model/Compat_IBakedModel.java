package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.model;

import java.util.List;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state.Compat_IBlockState;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_EnumFacing;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.texture.Compat_TextureAtlasSprite;
import net.minecraft.client.renderer.block.model.IBakedModel;

public interface Compat_IBakedModel {
	boolean Compat_func_177555_b();

	boolean Compat_func_177556_c();

	boolean Compat_func_188618_c();

	Compat_ItemOverrideList Compat_func_188617_f();

	Compat_TextureAtlasSprite Compat_func_177554_e();

	List<Compat_BakedQuad> Compat_func_188616_a(Compat_IBlockState state, Compat_EnumFacing side, long rand);

	public static IBakedModel getReal(Compat_IBakedModel model) {
		if (model instanceof Wrapper2_IBakedModel) {
			return ((Wrapper2_IBakedModel) model).getReal();
		}

		return new Wrapper_IBakedModel(model);
	}
}
