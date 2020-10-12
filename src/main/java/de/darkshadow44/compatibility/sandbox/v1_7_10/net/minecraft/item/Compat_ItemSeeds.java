package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.item.ItemSeeds;

public class Compat_ItemSeeds extends Compat_Item {
	private ItemSeeds original;
	private CompatI_ItemSeeds thisReal;

	// When called from Mod
	public Compat_ItemSeeds() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, this, null, null), null); // TODO
	}

	// When called from child
	protected Compat_ItemSeeds(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ItemSeeds(ItemSeeds original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_ItemSeeds thisReal, ItemSeeds original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public ItemSeeds getReal() {
		return original == null ? thisReal.get() : original;
	}
}
