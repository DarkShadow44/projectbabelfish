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

	public int[][] Compat_func_147965_a(int p1) {
		if (original == null)
			return thisReal.getFrameTextureDataSuper(p1);
		else
			return original.getFrameTextureData(p1);
	}

	public int Compat_func_94216_b() {
		if (original == null)
			return thisReal.getIconHeightSuper();
		else
			return original.getIconHeight();
	}

	public int Compat_func_94211_a() {
		if (original == null)
			return thisReal.getIconWidthSuper();
		else
			return original.getIconWidth();
	}

	public String Compat_func_94215_i() {
		if (original == null)
			return thisReal.getIconNameSuper();
		else
			return original.getIconName();
	}

	public float Compat_func_94214_a(double p1) {
		if (original == null)
			return thisReal.getInterpolatedUSuper(p1);
		else
			return original.getInterpolatedU(p1);
	}

	public float Compat_func_94207_b(double p1) {
		if (original == null)
			return thisReal.getInterpolatedVSuper(p1);
		else
			return original.getInterpolatedV(p1);
	}
}
