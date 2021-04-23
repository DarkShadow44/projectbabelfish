package compat.sandbox.net.minecraft.client.renderer.entity;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.client.renderer.entity.RenderBat;
import net.minecraft.entity.passive.EntityBat;

public class Compat_RenderBat extends Compat_RenderLiving<EntityBat> {
	private CompatI_RenderBat wrapper;

	// When called from Mod
	public Compat_RenderBat(Compat_RenderManager renderManager) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_RenderBat.class, this, renderManager.getReal()));
	}

	// When called from child
	protected Compat_RenderBat(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_RenderBat(RenderBat original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_RenderBat.class, original));
	}

	protected void initialize(CompatI_RenderBat wrapper) {
		this.wrapper = wrapper;
	}

	public RenderBat getReal() {
		return wrapper.get();
	}
}
