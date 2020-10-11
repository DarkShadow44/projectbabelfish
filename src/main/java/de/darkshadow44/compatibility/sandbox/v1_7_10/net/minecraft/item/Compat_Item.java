package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.item.Item;

public class Compat_Item {
	private Item original;
	private CompatI_Item thisReal;

	// When called from Mod
	public Compat_Item() {
		initialize(new CompatReal_Item(this), null);
	}

	// When called from child
	protected Compat_Item(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Item(Item original) {
		initialize(null, original);
	}

	protected void initialize(CompatI_Item thisReal, Item original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public Item getReal() {
		return original == null ? thisReal.get() : original;
	}
}
