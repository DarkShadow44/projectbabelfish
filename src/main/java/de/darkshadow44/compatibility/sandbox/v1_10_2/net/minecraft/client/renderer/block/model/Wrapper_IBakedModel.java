package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.model;

import java.util.ArrayList;
import java.util.List;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state.Wrapper_IBlockState;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_EnumFacing;
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
		List<Compat_BakedQuad> result = fake.getQuads(new Wrapper_IBlockState(state), Compat_EnumFacing.map_real_to_fake(side), rand);

		List<BakedQuad> ret = new ArrayList<>();

		for (Compat_BakedQuad quad : result) {
			ret.add(quad.getReal());
		}

		return ret;
	}

	@Override
	public boolean isAmbientOcclusion() {
		return fake.isAmbientOcclusion();
	}

	@Override
	public boolean isGui3d() {
		return fake.isGui3d();
	}

	@Override
	public boolean isBuiltInRenderer() {
		return fake.isBuiltInRenderer();
	}

	@Override
	public TextureAtlasSprite getParticleTexture() {
		return fake.getParticleTexture().getReal();
	}

	@Override
	public ItemOverrideList getOverrides() {
		return fake.getOverrides().getReal();
	}

}
