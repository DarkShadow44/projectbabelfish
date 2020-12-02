package compat.core.model.variabletexture.block;

import java.util.ArrayList;
import java.util.List;

import javax.vecmath.Matrix4f;

import org.apache.commons.lang3.tuple.Pair;

import compat.core.model.TransformHelper;
import compat.mixinhelper.ForgeBlockModelRendererHelper;
import compat.sandbox.cpw.mods.fml.client.registry.Compat_ISimpleBlockRenderingHandler;
import compat.sandbox.net.minecraft.block.Compat_Block;
import compat.sandbox.net.minecraft.client.renderer.Compat_RenderBlocks;
import compat.sandbox.net.minecraft.client.renderer.Compat_Tessellator;
import compat.sandbox.net.minecraft.world.Compat_IBlockAccess;
import compat.sandbox.net.minecraft.world.Wrapper_IBlockAccess;
import compat.sandbox.net.minecraftforge.fml.client.registry.Compat_RenderingRegistry;
import compat.sandbox.org.lwjgl.opengl.Compat_GL11;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.model.PerspectiveMapWrapper;

public class BakedModelBlockVariableTexture implements IBakedModel {

	private final Block blockFromItem;
	private final int itemMeta;

	public BakedModelBlockVariableTexture(Block blockFromItem, int itemMeta) {
		this.blockFromItem = blockFromItem;
		this.itemMeta = itemMeta;
	}

	@Override
	public Pair<? extends IBakedModel, Matrix4f> handlePerspective(TransformType cameraTransformType) {
		return PerspectiveMapWrapper.handlePerspective(this, TransformHelper.BLOCK_GENERATED, cameraTransformType);
	}

	@Override
	public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) {
		Block blockReal = state == null ? blockFromItem : state.getBlock();
		Compat_Block block = Compat_Block.getFake(blockReal);
		int renderId = block.Compat_func_149645_b();

		if (renderId != 0) {
			if (state == null) {
				return getQuadsISBRHInventory(block, itemMeta, Compat_RenderingRegistry.getHandler(renderId));
			}

			if (side == null) {
				Compat_IBlockAccess world = new Wrapper_IBlockAccess(ForgeBlockModelRendererHelper.currentWorld);
				BlockPos pos = ForgeBlockModelRendererHelper.currentPos;
				return getQuadsISBRHWorld(world, block, pos, Compat_RenderingRegistry.getHandler(renderId));
			}
			return new ArrayList<>();
		}

		return new ArrayList<>();
		// throw new RuntimeException("Not Implemented!");
	}

	private List<BakedQuad> getQuadsISBRHWorld(Compat_IBlockAccess world, Compat_Block block, BlockPos pos, Compat_ISimpleBlockRenderingHandler handler) {
		Compat_Tessellator.resetForISBRH(true);

		Compat_GL11.setInISBRH(true);
		handler.renderWorldBlock(world, pos.getX(), pos.getY(), pos.getZ(), block, 0, new Compat_RenderBlocks());
		Compat_GL11.setInISBRH(false);

		List<BakedQuad> quads = Compat_Tessellator.getQuads();
		return quads;
	}

	private List<BakedQuad> getQuadsISBRHInventory(Compat_Block block, int meta, Compat_ISimpleBlockRenderingHandler handler) {
		Compat_Tessellator.resetForISBRH(false);

		Compat_GL11.setInISBRH(true);
		handler.renderInventoryBlock(block, meta, 0, new Compat_RenderBlocks());
		Compat_GL11.setInISBRH(false);

		List<BakedQuad> quads = Compat_Tessellator.getQuads();
		return quads;
	}

	@Override
	public boolean isAmbientOcclusion() {
		return true;
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
