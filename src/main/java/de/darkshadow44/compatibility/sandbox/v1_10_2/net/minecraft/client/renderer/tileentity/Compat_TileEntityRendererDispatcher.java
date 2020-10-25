package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.tileentity;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.texture.Compat_TextureManager;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;

public class Compat_TileEntityRendererDispatcher {

	private final TileEntityRendererDispatcher original;

	public Compat_TileEntityRendererDispatcher(TileEntityRendererDispatcher original) {
		this.original = original;
	}

	public TileEntityRendererDispatcher getReal() {
		return original;
	}

	public Compat_TextureManager Compat_get_field_147553_e() {
		return new Compat_TextureManager(original.renderEngine);
	}
}
