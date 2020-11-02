package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.texture;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;

public class Compat_TextureAtlasSprite {
	private CompatI_TextureAtlasSprite wrapper;

	// When called from Mod
	public Compat_TextureAtlasSprite(String spriteName) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_TextureAtlasSprite.class, this, spriteName));
	}

	// When called from child
	protected Compat_TextureAtlasSprite(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_TextureAtlasSprite(TextureAtlasSprite original) {
		this.initialize(Factory.createWrapper(CompatI_TextureAtlasSprite.class, original));
	}

	protected void initialize(CompatI_TextureAtlasSprite wrapper) {
		this.wrapper = wrapper;
	}

	public TextureAtlasSprite getReal() {
		return wrapper.get();
	}
}
