package compat.sandbox.net.minecraft.client.renderer.block.model;

import java.util.ArrayList;
import java.util.List;

import compat.sandbox.net.minecraft.block.state.Compat_IBlockState;
import compat.sandbox.net.minecraft.util.Compat_EnumFacing;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.EnumFacing;

public class Wrapper_IBakedModel implements IBakedModel {

	private final Compat_IBakedModel fake;

	public Wrapper_IBakedModel(Compat_IBakedModel fake) {
		this.fake = fake;
	}

	@Override
	public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) {
		List<Compat_BakedQuad> result = fake.Compat_func_188616_a(Compat_IBlockState.getFake(state), Compat_EnumFacing.map_real_to_fake(side), rand);

		List<BakedQuad> ret = new ArrayList<>();

		for (Compat_BakedQuad quad : result) {
			ret.add(quad.getReal());
		}

		return ret;
	}

	@Override
	public boolean isAmbientOcclusion() {
		return fake.Compat_func_177555_b();
	}

	@Override
	public boolean isGui3d() {
		return fake.Compat_func_177556_c();
	}

	@Override
	public boolean isBuiltInRenderer() {
		return fake.Compat_func_188618_c();
	}

	@Override
	public TextureAtlasSprite getParticleTexture() {
		return fake.Compat_func_177554_e().getReal();
	}

	@Override
	public ItemOverrideList getOverrides() {
		return fake.Compat_func_188617_f().getReal();
	}

}
