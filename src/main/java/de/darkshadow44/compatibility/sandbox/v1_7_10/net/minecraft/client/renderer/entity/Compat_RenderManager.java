package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.entity;

import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.Compat_RenderItem;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.texture.Compat_TextureManager;
import net.minecraft.client.renderer.entity.RenderManager;

public class Compat_RenderManager {
	private RenderManager original;
	private CompatI_RenderManager thisReal;

	// When called from Mod
	public Compat_RenderManager(Compat_TextureManager textureManager, Compat_RenderItem renderItem) {
		initialize(new CompatReal_RenderManager(this, textureManager.getReal(), renderItem.getReal()), null);
	}

	// When called from child
	protected Compat_RenderManager(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_RenderManager(RenderManager original) {
		initialize(null, original);
	}

	protected void initialize(CompatI_RenderManager thisReal, RenderManager original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public RenderManager getReal() {
		return original == null ? thisReal.get() : original;
	}
}
