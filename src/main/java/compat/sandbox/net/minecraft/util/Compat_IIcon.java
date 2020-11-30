package compat.sandbox.net.minecraft.util;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.ResourceLocation;

public interface Compat_IIcon {
	public ResourceLocation getLocation();

	public float Compat_func_94214_a(double p1);

	public float Compat_func_94207_b(double p2);

	public void updateSprite(TextureAtlasSprite sprite);
}
