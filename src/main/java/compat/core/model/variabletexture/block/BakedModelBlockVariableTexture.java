package compat.core.model.variabletexture.block;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.model.IModelState;

public class BakedModelBlockVariableTexture implements IBakedModel {

	public final IModelState state;
	public final VertexFormat format;

	public BakedModelBlockVariableTexture(VertexFormat format, IModelState state) {
		this.format = format;
		this.state = state;
	}

	@Override
	public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) {
		List<BakedQuad> quads = new ArrayList<>();
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
		return null; // TODO ?
	}

	@Override
	public ItemOverrideList getOverrides() {
		return ItemOverrideList.NONE;
	}
}
