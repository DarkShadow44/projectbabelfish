package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer;

import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelManager;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.client.renderer.texture.TextureManager;

public class CompatReal_RenderItem extends RenderItem implements CompatI_RenderItem {
	@SuppressWarnings("unused")
	private Compat_RenderItem thisFake;

	public CompatReal_RenderItem(Compat_RenderItem thisFake, TextureManager textureManger, ModelManager modelManager, ItemColors colors) {
		super(textureManger, modelManager, colors);
		this.thisFake = thisFake;
	}

	@Override
	public RenderItem get() {
		return this;
	}
}
