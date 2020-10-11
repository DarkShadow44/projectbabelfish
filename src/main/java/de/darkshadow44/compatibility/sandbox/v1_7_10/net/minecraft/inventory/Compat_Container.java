package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.inventory;

import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.inventory.Container;

public class Compat_Container {
	private Container original;
	private CompatI_Container thisReal;

	// When called from Mod
	public Compat_Container() {
		initialize(new CompatReal_Container(this), null);
	}

	// When called from child
	protected Compat_Container(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Container(Container original) {
		initialize(null, original);
	}

	protected void initialize(CompatI_Container thisReal, Container original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public Container getReal() {
		return original == null ? thisReal.get() : original;
	}
}
