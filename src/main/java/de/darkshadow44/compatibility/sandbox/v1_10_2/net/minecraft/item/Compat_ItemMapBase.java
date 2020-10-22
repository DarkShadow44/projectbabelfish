package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.item;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.item.ItemMapBase;

public class Compat_ItemMapBase extends Compat_Item {
	private ItemMapBase original;
	private CompatI_ItemMapBase thisReal;

	// When called from Mod
	public Compat_ItemMapBase() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ItemMapBase.class, this), null);
	}

	// When called from child
	protected Compat_ItemMapBase(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ItemMapBase(ItemMapBase original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_ItemMapBase thisReal, ItemMapBase original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public ItemMapBase getReal() {
		return original == null ? thisReal.get() : original;
	}
}
