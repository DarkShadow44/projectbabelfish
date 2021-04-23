package compat.sandbox.net.minecraft.stats;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.stats.StatBase;

public class Compat_StatBase {
	private CompatI_StatBase wrapper;

	// When called from Mod
	public Compat_StatBase() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_StatBase.class, this));
	}

	// When called from child
	protected Compat_StatBase(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_StatBase(StatBase original) {
		this.initialize(Factory.createWrapper(CompatI_StatBase.class, original));
	}

	protected void initialize(CompatI_StatBase wrapper) {
		this.wrapper = wrapper;
	}

	public StatBase getReal() {
		return wrapper.get();
	}
}
