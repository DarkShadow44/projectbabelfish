package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.model;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.renderer.block.model.BakedQuad;

public class Compat_BakedQuad {
	private BakedQuad original;
	private CompatI_BakedQuad thisReal;

	// When called from Mod
	public Compat_BakedQuad() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BakedQuad.class, this), null);
	}

	// When called from child
	protected Compat_BakedQuad(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_BakedQuad(BakedQuad original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BakedQuad thisReal, BakedQuad original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public BakedQuad getReal() {
		return original == null ? thisReal.get() : original;
	}
}
