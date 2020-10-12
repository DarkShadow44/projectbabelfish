package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.entity;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.model.Compat_ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.EntityLiving;

public class Compat_RenderBiped<T extends EntityLiving> extends Compat_RenderLiving<T> {
	private RenderBiped<T> original;
	private CompatI_RenderBiped<T> thisReal;

	// When called from Mod
	public Compat_RenderBiped(Compat_RenderManager renderManager, Compat_ModelBiped model, float p1) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, this, renderManager.getReal(), model.getReal(), p1), null);
	}

	// When called from child
	protected Compat_RenderBiped(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_RenderBiped(RenderBiped<T> original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_RenderBiped<T> thisReal, RenderBiped<T> original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public RenderBiped<T> getReal() {
		return original == null ? thisReal.get() : original;
	}
}
