package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.item;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.item.Item;

public class Compat_Item {
	private Item original;
	private CompatI_Item thisReal;

	// When called from Mod
	public Compat_Item() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Item.class, this), null);
	}

	// When called from child
	protected Compat_Item(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Item(Item original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_Item thisReal, Item original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public Item getReal() {
		return original == null ? thisReal.get() : original;
	}
}
