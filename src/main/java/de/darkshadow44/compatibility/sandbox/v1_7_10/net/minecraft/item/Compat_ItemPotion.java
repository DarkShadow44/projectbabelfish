package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.item.ItemPotion;

public class Compat_ItemPotion extends Compat_Item {
	private ItemPotion original;
	private CompatI_ItemPotion thisReal;

	// When called from Mod
	public Compat_ItemPotion() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, this), null);
	}

	// When called from child
	protected Compat_ItemPotion(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ItemPotion(ItemPotion original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_ItemPotion thisReal, ItemPotion original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public ItemPotion getReal() {
		return original == null ? thisReal.get() : original;
	}
}
