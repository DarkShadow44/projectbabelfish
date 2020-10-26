package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.model;

import java.util.ArrayList;
import java.util.List;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state.Compat_IBlockState;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_EnumFacing;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.texture.Compat_TextureAtlasSprite;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;

public class Wrapper2_IBakedModel implements Compat_IBakedModel {

	private final IBakedModel real;

	public Wrapper2_IBakedModel(IBakedModel real) {
		this.real = real;
	}

	@Override
	public boolean Compat_func_177555_b() {
		return real.isAmbientOcclusion();
	}

	@Override
	public boolean Compat_func_177556_c() {
		return real.isGui3d();
	}

	@Override
	public boolean Compat_func_188618_c() {
		return real.isBuiltInRenderer();
	}

	@Override
	public Compat_ItemOverrideList Compat_func_188617_f() {
		return new Compat_ItemOverrideList(real.getOverrides());
	}

	@Override
	public Compat_TextureAtlasSprite Compat_func_177554_e() {
		return new Compat_TextureAtlasSprite(real.getParticleTexture());
	}

	@Override
	public List<Compat_BakedQuad> Compat_func_188616_a(Compat_IBlockState state, Compat_EnumFacing side, long rand) {
		List<BakedQuad> quads = real.getQuads(state.getReal(), side.getReal(), rand);
		List<Compat_BakedQuad> ret = new ArrayList<>();
		for (BakedQuad quad : quads) {
			ret.add(new Compat_BakedQuad(quad));
		}
		return ret;
	}

	public IBakedModel getReal() {
		return real;
	}
}
