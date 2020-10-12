package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.entity;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;

public class Compat_Render<T extends Entity> {
	private Render<T> original;
	private CompatI_Render<T> thisReal;

	// When called from Mod
	public Compat_Render(Compat_RenderManager manager) {
		this.initialize(Factory.create(CtorPos.POS1, this, manager.getReal()), null);
	}

	// When called from child
	protected Compat_Render(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Render(Render<T> original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_Render<T> thisReal, Render<T> original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public Render<T> getReal() {
		return original == null ? thisReal.get() : original;
	}
}
