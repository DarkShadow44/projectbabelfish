package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.statemap;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;

public class Compat_StateMapperBase {
	private StateMapperBase original;
	private CompatI_StateMapperBase thisReal;

	// When called from Mod
	public Compat_StateMapperBase() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_StateMapperBase.class, this), null);
	}

	// When called from child
	protected Compat_StateMapperBase(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_StateMapperBase(StateMapperBase original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_StateMapperBase thisReal, StateMapperBase original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public StateMapperBase getReal() {
		return original == null ? thisReal.get() : original;
	}
}
