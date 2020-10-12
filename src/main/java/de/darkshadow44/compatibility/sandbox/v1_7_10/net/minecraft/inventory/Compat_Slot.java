package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.inventory;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.inventory.Slot;

public class Compat_Slot {
	private Slot original;
	private CompatI_Slot thisReal;

	// When called from Mod
	public Compat_Slot() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Slot.class, this, null, 0, 0, 0), null); // TODO
	}

	// When called from child
	protected Compat_Slot(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Slot(Slot original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_Slot thisReal, Slot original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public Slot getReal() {
		return original == null ? thisReal.get() : original;
	}
}
