package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.entity;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.renderer.entity.RenderBat;
import net.minecraft.entity.passive.EntityBat;

public class Compat_RenderBat extends Compat_RenderLiving<EntityBat> {
	private RenderBat original;
	private CompatI_RenderBat thisReal;

	// When called from Mod
	public Compat_RenderBat(Compat_RenderManager renderManager) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_RenderBat.class, this, renderManager.getReal()), null);
	}

	// When called from child
	protected Compat_RenderBat(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_RenderBat(RenderBat original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_RenderBat thisReal, RenderBat original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public RenderBat getReal() {
		return original == null ? thisReal.get() : original;
	}
}
