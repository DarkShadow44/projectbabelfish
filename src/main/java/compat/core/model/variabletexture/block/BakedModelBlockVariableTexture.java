package compat.core.model.variabletexture.block;

import java.util.ArrayList;
import java.util.List;

import compat.sandbox.cpw.mods.fml.client.registry.Compat_ISimpleBlockRenderingHandler;
import compat.sandbox.net.minecraft.block.CompatI_Block;
import compat.sandbox.net.minecraft.block.Compat_Block;
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
		Compat_Block block = ((CompatI_Block) state.getBlock()).getFake();

		if (block instanceof Compat_ISimpleBlockRenderingHandler) {
			return getQuadsISBRH((Compat_ISimpleBlockRenderingHandler) block);
		}

		throw new RuntimeException("Not Implemented!");
	}

	private List<BakedQuad> getQuadsISBRH(Compat_ISimpleBlockRenderingHandler handler) {
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
