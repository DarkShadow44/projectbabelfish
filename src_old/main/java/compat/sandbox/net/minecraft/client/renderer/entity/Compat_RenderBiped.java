package compat.sandbox.net.minecraft.client.renderer.entity;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.client.model.Compat_ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.EntityLiving;

public class Compat_RenderBiped<T extends EntityLiving> extends Compat_RenderLiving<T> {
	private CompatI_RenderBiped<T> wrapper;

	// When called from Mod
	public Compat_RenderBiped(Compat_RenderManager renderManager, Compat_ModelBiped model, float p1) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_RenderBiped.class, this, renderManager.getReal(), model.getReal(), p1));
	}

	// When called from child
	protected Compat_RenderBiped(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_RenderBiped(RenderBiped<T> original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_RenderBiped.class, original));
	}

	protected void initialize(CompatI_RenderBiped<T> wrapper) {
		this.wrapper = wrapper;
	}

	public RenderBiped<T> getReal() {
		return wrapper.get();
	}
}
