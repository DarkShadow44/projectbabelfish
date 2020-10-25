package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.texture;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_ResourceLocation;
import net.minecraft.client.renderer.texture.TextureManager;

public class Compat_TextureManager {

	private final TextureManager original;

	public Compat_TextureManager(TextureManager original) {
		this.original = original;
	}

	public TextureManager getReal() {
		return original;
	}

	public void Compat_func_110577_a(Compat_ResourceLocation location) {
		original.bindTexture(location.getReal());
	}
}
