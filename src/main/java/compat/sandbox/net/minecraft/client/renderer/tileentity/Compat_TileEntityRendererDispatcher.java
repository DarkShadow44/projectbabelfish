package compat.sandbox.net.minecraft.client.renderer.tileentity;

import compat.sandbox.net.minecraft.client.renderer.texture.Compat_TextureManager;
import compat.sandbox.net.minecraft.world.Compat_World;
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

	public Compat_World Compat_get_field_147550_f() {
		return new Compat_World(original.world);
	}
}
