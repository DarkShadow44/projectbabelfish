package compat.sandbox.net.minecraft.client.renderer.block.model;

import java.util.List;

import compat.sandbox.net.minecraft.block.state.Compat_IBlockState;
import compat.sandbox.net.minecraft.client.renderer.texture.Compat_TextureAtlasSprite;
import compat.sandbox.net.minecraft.util.Compat_EnumFacing;
import net.minecraft.client.renderer.model.IBakedModel;

public interface Compat_IBakedModel {
	public boolean Compat_func_177555_b();

	public boolean Compat_func_177556_c();

	public boolean Compat_func_188618_c();

	public Compat_ItemOverrideList Compat_func_188617_f();

	public Compat_TextureAtlasSprite Compat_func_177554_e();

	public List<Compat_BakedQuad> Compat_func_188616_a(Compat_IBlockState state, Compat_EnumFacing side, long rand);

	public static IBakedModel getReal(Compat_IBakedModel model) {
		if (model instanceof Wrapper2_IBakedModel) {
			return ((Wrapper2_IBakedModel) model).getReal();
		}

		return new Wrapper_IBakedModel(model);
	}

	public Compat_ItemCameraTransforms Compat_func_177552_f();
}
