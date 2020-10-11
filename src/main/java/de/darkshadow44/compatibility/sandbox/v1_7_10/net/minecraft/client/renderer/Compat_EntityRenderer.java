package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer;

import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.Compat_Minecraft;
import net.minecraft.client.renderer.EntityRenderer;

public class Compat_EntityRenderer {
	private EntityRenderer original;
	private CompatI_EntityRenderer thisReal;

	// When called from Mod
	public Compat_EntityRenderer(Compat_Minecraft mc) {
		initialize(new CompatReal_EntityRenderer(this, mc.getReal(), null), null); // TODO
	}

	// When called from child
	protected Compat_EntityRenderer(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_EntityRenderer(EntityRenderer original) {
		initialize(null, original);
	}

	protected void initialize(CompatI_EntityRenderer thisReal, EntityRenderer original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityRenderer getReal() {
		return original == null ? thisReal.get() : original;
	}
}
