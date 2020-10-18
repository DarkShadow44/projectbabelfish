package de.darkshadow44.compatibility.core.model.variabletexture;

import java.util.List;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.model.IModelState;

public class BakedModelItemVariableTexture implements IBakedModel {

	private final ImmutableList<BakedQuad> quads;
	private final TextureAtlasSprite particle;

	public final IModelState state;
	public final VertexFormat format;

	public BakedModelItemVariableTexture(ImmutableList<BakedQuad> quads, TextureAtlasSprite particle, VertexFormat format, IModelState state) {
		this.quads = quads;
		this.particle = particle;
		this.format = format;
		this.state = state;
	}

	@Override
	public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) {
		return quads;
	}

	@Override
	public boolean isAmbientOcclusion() {
		return false;
	}

	@Override
	public boolean isGui3d() {
		return false;
	}

	@Override
	public boolean isBuiltInRenderer() {
		return false;
	}

	@Override
	public TextureAtlasSprite getParticleTexture() {
		return particle;
	}

	@Override
	public ItemOverrideList getOverrides() {
		return ModelOverridesItemVariableTexture.INSTANCE;
	}
}
