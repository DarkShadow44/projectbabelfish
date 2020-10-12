package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.entity;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.renderer.entity.RenderVillager;
import net.minecraft.entity.passive.EntityVillager;

public class Compat_RenderVillager extends Compat_RenderLiving<EntityVillager> {
	private RenderVillager original;
	private CompatI_RenderVillager thisReal;

	// When called from Mod
	public Compat_RenderVillager(Compat_RenderManager renderManager) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_RenderVillager.class, this, renderManager.getReal()), null);
	}

	// When called from child
	protected Compat_RenderVillager(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_RenderVillager(RenderVillager original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_RenderVillager thisReal, RenderVillager original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public RenderVillager getReal() {
		return original == null ? thisReal.get() : original;
	}
}
