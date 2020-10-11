package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.item.ItemSword;

public class Compat_ItemSword extends Compat_Item {
	private ItemSword original;
	private CompatI_ItemSword thisReal;

	// When called from Mod
	public Compat_ItemSword(Compat_Item_ToolMaterial material) {
		super(ParentSelector.NULL);
		this.initialize(new CompatReal_ItemSword(this, material.getReal()), null);
	}

	// When called from child
	protected Compat_ItemSword(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ItemSword(ItemSword original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_ItemSword thisReal, ItemSword original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public ItemSword getReal() {
		return original == null ? thisReal.get() : original;
	}
}
