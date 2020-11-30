package compat.core.model.variabletexture.block;

import java.util.List;

import compat.mixinhelper.ForgeBlockModelRendererHelper;
import compat.sandbox.cpw.mods.fml.client.registry.Compat_ISimpleBlockRenderingHandler;
import compat.sandbox.net.minecraft.block.CompatI_Block;
import compat.sandbox.net.minecraft.block.Compat_Block;
import compat.sandbox.net.minecraft.client.renderer.Compat_RenderBlocks;
import compat.sandbox.net.minecraft.client.renderer.Compat_Tessellator;
import compat.sandbox.net.minecraft.world.Compat_IBlockAccess;
import compat.sandbox.net.minecraft.world.Wrapper_IBlockAccess;
import compat.sandbox.net.minecraftforge.fml.client.registry.Compat_RenderingRegistry;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
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

		int renderId = block.Compat_func_149645_b();

		if (renderId != 0) {
			return getQuadsISBRH(state, Compat_RenderingRegistry.getHandler(renderId));
		}

		throw new RuntimeException("Not Implemented!");
	}

	private List<BakedQuad> getQuadsISBRH(IBlockState state, Compat_ISimpleBlockRenderingHandler handler) {
		Compat_Block block = Compat_Block.getFake(state.getBlock());
		Compat_IBlockAccess world = new Wrapper_IBlockAccess(ForgeBlockModelRendererHelper.currentWorld);
		BlockPos pos = ForgeBlockModelRendererHelper.currentPos;

		Compat_Tessellator.resetForISBRH();

		handler.renderWorldBlock(world, pos.getX(), pos.getY(), pos.getZ(), block, 0, new Compat_RenderBlocks());

		List<BakedQuad> quads = Compat_Tessellator.getQuads();
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
