package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.texture;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;

public class Compat_TextureAtlasSprite {
	private CompatI_TextureAtlasSprite wrapper;

	// When called from Mod
	public Compat_TextureAtlasSprite() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_TextureAtlasSprite.class, this));
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

	public int[][] Compat_func_147965_a(int p1) {
		return wrapper.getFrameTextureDataSuper(p1);
	}

	public int Compat_func_94216_b() {
		return wrapper.getIconHeightSuper();
	}

	public int Compat_func_94211_a() {
		return wrapper.getIconWidthSuper();
	}

	public String Compat_func_94215_i() {
		return wrapper.getIconNameSuper();
	}

	public float Compat_func_94214_a(double p1) {
		return wrapper.getInterpolatedUSuper(p1);
	}

	public float Compat_func_94207_b(double p1) {
		return wrapper.getInterpolatedVSuper(p1);
	}
}
