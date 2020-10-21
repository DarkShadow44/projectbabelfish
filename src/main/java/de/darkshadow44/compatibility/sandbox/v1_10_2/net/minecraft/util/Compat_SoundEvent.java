package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.util.SoundEvent;

public class Compat_SoundEvent {
	private SoundEvent original;
	private CompatI_SoundEvent thisReal;

	// When called from Mod
	public Compat_SoundEvent() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_SoundEvent.class, this), null);
	}

	// When called from child
	protected Compat_SoundEvent(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_SoundEvent(SoundEvent original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_SoundEvent thisReal, SoundEvent original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public SoundEvent getReal() {
		return original == null ? thisReal.get() : original;
	}
}
