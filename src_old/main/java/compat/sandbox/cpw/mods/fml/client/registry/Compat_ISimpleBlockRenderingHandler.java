package compat.sandbox.cpw.mods.fml.client.registry;

import compat.sandbox.net.minecraft.block.Compat_Block;
import compat.sandbox.net.minecraft.client.renderer.Compat_RenderBlocks;
import compat.sandbox.net.minecraft.world.Compat_IBlockAccess;

public interface Compat_ISimpleBlockRenderingHandler {
	void Compat_renderInventoryBlock(Compat_Block block, int metadata, int modelId, Compat_RenderBlocks renderer);

	boolean Compat_renderWorldBlock(Compat_IBlockAccess world, int x, int y, int z, Compat_Block block, int modelId, Compat_RenderBlocks renderer);
}
