package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.texture;

import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;

public class Compat_TextureAtlasSprite {
	private TextureAtlasSprite original;
	private CompatI_TextureAtlasSprite thisReal;

	// When called from Mod
	public Compat_TextureAtlasSprite(String spriteName) {
		initialize(new CompatReal_TextureAtlasSprite(this, spriteName), null);
	}

	// When called from child
	protected Compat_TextureAtlasSprite(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_TextureAtlasSprite(TextureAtlasSprite original) {
		initialize(null, original);
	}

	protected void initialize(CompatI_TextureAtlasSprite thisReal, TextureAtlasSprite original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public TextureAtlasSprite getReal() {
		return original == null ? thisReal.get() : original;
	}
}
