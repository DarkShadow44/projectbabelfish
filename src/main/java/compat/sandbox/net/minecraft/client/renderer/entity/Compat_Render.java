package compat.sandbox.net.minecraft.client.renderer.entity;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.world.entity.Entity;

public class Compat_Render<T extends Entity> {
	private CompatI_Render<T> wrapper;

	// When called from Mod
	public Compat_Render(Compat_RenderManager manager) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Render.class, this, manager.getReal()));
	}

	// When called from child
	protected Compat_Render(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Render(Render<T> original) {
		this.initialize(Factory.createWrapper(CompatI_Render.class, original));
	}

	protected void initialize(CompatI_Render<T> wrapper) {
		this.wrapper = wrapper;
	}

	public Render<T> getReal() {
		return wrapper.get();
	}
}
