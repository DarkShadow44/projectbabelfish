package compat.sandbox.net.minecraft.client.renderer.entity;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.client.model.Compat_ModelBase;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.EntityLivingBase;

public class Compat_RenderLivingBase<T extends EntityLivingBase> extends Compat_Render<T> {
	private CompatI_RenderLivingBase<T> wrapper;

	// When called from Mod
	public Compat_RenderLivingBase(Compat_RenderManager renderManager, Compat_ModelBase model, float p1) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_RenderLivingBase.class, this, renderManager.getReal(), model.getReal(), p1));
	}

	// When called from child
	protected Compat_RenderLivingBase(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_RenderLivingBase(RenderLivingBase<T> original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_RenderLivingBase.class, original));
	}

	protected void initialize(CompatI_RenderLivingBase<T> wrapper) {
		this.wrapper = wrapper;
	}

	public RenderLivingBase<T> getReal() {
		return wrapper.get();
	}
}
