package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.texture;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;

public class CompatReal_TextureAtlasSprite extends TextureAtlasSprite implements CompatI_TextureAtlasSprite {
	@SuppressWarnings("unused")
	private Compat_TextureAtlasSprite thisFake;

	public CompatReal_TextureAtlasSprite(Compat_TextureAtlasSprite thisFake, String spriteName) {
		super(spriteName);
		this.thisFake = thisFake;
	}

	@Override
	public TextureAtlasSprite get() {
		return this;
	}
}
