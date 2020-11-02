package compat.sandbox.net.minecraft.client.renderer.texture;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;

public interface CompatI_TextureAtlasSprite {
	public TextureAtlasSprite get();

	public int getIconWidthSuper();

	public int getIconHeightSuper();

	public int[][] getFrameTextureDataSuper(int p1);

	public String getIconNameSuper();

	public float getInterpolatedUSuper(double p1);

	public float getInterpolatedVSuper(double p1);
}
