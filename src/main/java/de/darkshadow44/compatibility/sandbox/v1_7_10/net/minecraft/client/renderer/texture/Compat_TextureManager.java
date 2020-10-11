package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.texture;

import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.renderer.texture.TextureManager;

public class Compat_TextureManager {
	private TextureManager original;
	private CompatI_TextureManager thisReal;

	// When called from Mod
	public Compat_TextureManager() {
		initialize(new CompatReal_TextureManager(this, null), null); // TODO
	}

	// When called from child
	protected Compat_TextureManager(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_TextureManager(TextureManager original) {
		initialize(null, original);
	}

	protected void initialize(CompatI_TextureManager thisReal, TextureManager original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public TextureManager getReal() {
		return original == null ? thisReal.get() : original;
	}
}
