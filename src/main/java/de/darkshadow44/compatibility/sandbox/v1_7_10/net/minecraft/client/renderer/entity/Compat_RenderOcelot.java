package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.entity;

import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.renderer.entity.RenderOcelot;
import net.minecraft.entity.passive.EntityOcelot;

public class Compat_RenderOcelot extends Compat_RenderLiving<EntityOcelot> {
	private RenderOcelot original;
	private CompatI_RenderOcelot thisReal;

	// When called from Mod
	public Compat_RenderOcelot(Compat_RenderManager renderManager) {
		super(ParentSelector.NULL);
		this.initialize(new CompatReal_RenderOcelot(this, renderManager.getReal()), null);
	}

	// When called from child
	protected Compat_RenderOcelot(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_RenderOcelot(RenderOcelot original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_RenderOcelot thisReal, RenderOcelot original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public RenderOcelot getReal() {
		return original == null ? thisReal.get() : original;
	}
}
