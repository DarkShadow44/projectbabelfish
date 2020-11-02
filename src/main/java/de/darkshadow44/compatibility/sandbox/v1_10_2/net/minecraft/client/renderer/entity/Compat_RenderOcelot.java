package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.entity;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.renderer.entity.RenderOcelot;
import net.minecraft.entity.passive.EntityOcelot;

public class Compat_RenderOcelot extends Compat_RenderLiving<EntityOcelot> {
	private CompatI_RenderOcelot wrapper;

	// When called from Mod
	public Compat_RenderOcelot(Compat_RenderManager renderManager) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_RenderOcelot.class, this, renderManager.getReal()));
	}

	// When called from child
	protected Compat_RenderOcelot(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_RenderOcelot(RenderOcelot original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_RenderOcelot.class, original));
	}

	protected void initialize(CompatI_RenderOcelot wrapper) {
		this.wrapper = wrapper;
	}

	public RenderOcelot getReal() {
		return wrapper.get();
	}
}
