package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.Compat_Minecraft;
import net.minecraft.client.renderer.EntityRenderer;

public class Compat_EntityRenderer {
	private CompatI_EntityRenderer wrapper;

	// When called from Mod
	public Compat_EntityRenderer(Compat_Minecraft mc) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityRenderer.class, this, mc.getReal(), null)); // TODO
	}

	// When called from child
	protected Compat_EntityRenderer(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_EntityRenderer(EntityRenderer original) {
		this.initialize(Factory.createWrapper(CompatI_EntityRenderer.class, original));
	}

	protected void initialize(CompatI_EntityRenderer wrapper) {
		this.wrapper = wrapper;
	}

	public EntityRenderer getReal() {
		return wrapper.get();
	}
}
