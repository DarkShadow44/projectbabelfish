package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.entity;

import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.model.Compat_ModelBase;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.EntityLivingBase;

public class Compat_RenderLivingBase<T extends EntityLivingBase> extends Compat_Render<T> {
	private RenderLivingBase<T> original;
	private CompatI_RenderLivingBase<T> thisReal;

	// When called from Mod
	public Compat_RenderLivingBase(Compat_RenderManager renderManager, Compat_ModelBase model, float p1) {
		super(ParentSelector.NULL);
		this.initialize(new CompatReal_RenderLivingBase<T>(this, renderManager.getReal(), model.getReal(), p1), null);
	}

	// When called from child
	protected Compat_RenderLivingBase(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_RenderLivingBase(RenderLivingBase<T> original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_RenderLivingBase<T> thisReal, RenderLivingBase<T> original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public RenderLivingBase<T> getReal() {
		return original == null ? thisReal.get() : original;
	}
}
