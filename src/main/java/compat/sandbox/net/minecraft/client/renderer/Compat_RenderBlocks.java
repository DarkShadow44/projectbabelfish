package compat.sandbox.net.minecraft.client.renderer;

import compat.sandbox.net.minecraft.block.Compat_Block;
import compat.sandbox.net.minecraft.client.renderer.texture.Wrapper_IIcon;
import compat.sandbox.net.minecraft.util.Compat_IIcon;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;

public class Compat_RenderBlocks {

	public Compat_IIcon Compat_func_147787_a(Compat_Block block, int side, int meta) { // getBlockIconFromSideAndMetadata
		return block.Compat_func_149691_a(side, meta);
	}

	public Compat_IIcon getIconSafe(Compat_IIcon icon) {
		if (icon != null)
			return icon;

		TextureAtlasSprite sprite = ((TextureMap) Minecraft.getMinecraft().getTextureManager().getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE)).getAtlasSprite("missingno");

		return new Wrapper_IIcon(sprite);
	}
}
