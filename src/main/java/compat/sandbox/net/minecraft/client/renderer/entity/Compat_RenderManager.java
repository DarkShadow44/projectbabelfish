package compat.sandbox.net.minecraft.client.renderer.entity;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.client.renderer.texture.Compat_TextureManager;
import net.minecraft.client.renderer.entity.RenderManager;

public class Compat_RenderManager {
	private CompatI_RenderManager wrapper;

	// When called from Mod
	public Compat_RenderManager(Compat_TextureManager textureManager, Compat_RenderItem renderItem) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_RenderManager.class, this, textureManager.getReal(), renderItem.getReal()));
	}

	// When called from child
	protected Compat_RenderManager(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_RenderManager(RenderManager original) {
		this.initialize(Factory.createWrapper(CompatI_RenderManager.class, original));
	}

	protected void initialize(CompatI_RenderManager wrapper) {
		this.wrapper = wrapper;
	}

	public RenderManager getReal() {
		return wrapper.get();
	}
}
