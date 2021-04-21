package compat.sandbox.net.minecraft.client.renderer.entity;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.client.renderer.entity.RenderSprite;
import net.minecraft.client.renderer.model.ModelManager;
import net.minecraft.client.renderer.texture.TextureManager;

public class Compat_RenderItem {
	private CompatI_RenderItem wrapper;

	// When called from Mod
	public Compat_RenderItem() {
	}

	private final boolean initialized = false;

	@SuppressWarnings("unused")
	private void tryInit() {
		if (initialized) {
			return;
		}
		TextureManager textureManager = Minecraft.getInstance().getTextureManager();
		ModelManager modelManager = Minecraft.getInstance().getBlockRendererDispatcher().getBlockModelShapes().getModelManager();
		ItemColors itemColors = new ItemColors();
		this.initialize(Factory.create(CtorPos.POS1, CompatI_RenderItem.class, this, textureManager, modelManager, itemColors));
	}

	// When called from child
	protected Compat_RenderItem(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_RenderItem(RenderSprite original) {
		this.initialize(Factory.createWrapper(CompatI_RenderItem.class, original));
	}

	protected void initialize(CompatI_RenderItem wrapper) {
		this.wrapper = wrapper;
	}

	public RenderSprite getReal() {
		return wrapper.get();
	}
}
