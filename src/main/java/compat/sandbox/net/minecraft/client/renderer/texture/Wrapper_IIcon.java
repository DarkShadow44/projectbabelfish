package compat.sandbox.net.minecraft.client.renderer.texture;

import compat.sandbox.net.minecraft.util.Compat_IIcon;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.ResourceLocation;

public class Wrapper_IIcon implements Compat_IIcon {

	private TextureAtlasSprite sprite;
	private final ResourceLocation location;

	public Wrapper_IIcon(TextureAtlasSprite sprite) {
		this.sprite = sprite;
		this.location = new ResourceLocation(sprite.getIconName());
	}

	public Wrapper_IIcon(ResourceLocation location) {
		this.location = location;
	}

	@Override
	public void updateSprite(TextureAtlasSprite sprite) {
		this.sprite = sprite;
	}

	@Override
	public ResourceLocation getLocation() {
		return location;
	}

	@Override
	public float Compat_func_94214_a(double u) {
		return sprite.getInterpolatedU(u);
	}

	@Override
	public float Compat_func_94207_b(double v) {
		return sprite.getInterpolatedV(v);
	}
}
