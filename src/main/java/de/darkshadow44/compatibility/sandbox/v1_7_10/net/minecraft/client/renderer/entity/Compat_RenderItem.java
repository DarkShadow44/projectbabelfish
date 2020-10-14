package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.entity;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelManager;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.client.renderer.texture.TextureManager;

public class Compat_RenderItem {
	private RenderItem original;
	private CompatI_RenderItem thisReal;

	// When called from Mod
	public Compat_RenderItem() {
	}

	private boolean initialized = false;

	private void tryInit() {
		if (initialized) {
			return;
		}
		TextureManager textureManager = Minecraft.getMinecraft().getTextureManager();
		ModelManager modelManager = Minecraft.getMinecraft().getBlockRendererDispatcher().getBlockModelShapes().getModelManager();
		ItemColors itemColors = new ItemColors();
		this.initialize(Factory.create(CtorPos.POS1, CompatI_RenderItem.class, this, textureManager, modelManager, itemColors), null);
	}

	// When called from child
	protected Compat_RenderItem(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_RenderItem(RenderItem original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_RenderItem thisReal, RenderItem original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public RenderItem getReal() {
		return original == null ? thisReal.get() : original;
	}
}
