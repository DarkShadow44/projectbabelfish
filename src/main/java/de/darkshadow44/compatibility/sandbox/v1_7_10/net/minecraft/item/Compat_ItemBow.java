package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.item.ItemBow;

public class Compat_ItemBow extends Compat_Item {
	private ItemBow original;
	private CompatI_ItemBow thisReal;

	// When called from Mod
	public Compat_ItemBow() {
		super(ParentSelector.NULL);
		super.initialize(new CompatReal_ItemBow(this), null);
	}

	// When called from child
	protected Compat_ItemBow(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ItemBow(ItemBow original) {
		super(ParentSelector.NULL);
		super.initialize(null, original);
	}

	protected void initialize(CompatI_ItemBow thisReal, ItemBow original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public ItemBow getReal() {
		return original == null ? thisReal.get() : original;
	}
}
