package compat.sandbox.net.minecraft.inventory;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.inventory.Slot;

public class Compat_Slot {
	private CompatI_Slot wrapper;

	// When called from Mod
	public Compat_Slot() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Slot.class, this, null, 0, 0, 0)); // TODO
	}

	// When called from child
	protected Compat_Slot(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Slot(Slot original) {
		this.initialize(Factory.createWrapper(CompatI_Slot.class, original));
	}

	protected void initialize(CompatI_Slot wrapper) {
		this.wrapper = wrapper;
	}

	public Slot getReal() {
		return wrapper.get();
	}
}
