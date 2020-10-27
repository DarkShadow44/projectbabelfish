package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.texture;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;

public class Compat_TextureAtlasSprite {
	private TextureAtlasSprite original;
	private CompatI_TextureAtlasSprite thisReal;

	// When called from Mod
	public Compat_TextureAtlasSprite() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_TextureAtlasSprite.class, this), null);
	}

	// When called from child
	protected Compat_TextureAtlasSprite(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_TextureAtlasSprite(TextureAtlasSprite original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_TextureAtlasSprite thisReal, TextureAtlasSprite original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public TextureAtlasSprite getReal() {
		return original == null ? thisReal.get() : original;
	}
}
