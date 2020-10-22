package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.item;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.item.ItemEmptyMap;

public class Compat_ItemEmptyMap extends Compat_ItemMapBase {
	private ItemEmptyMap original;
	private CompatI_ItemEmptyMap thisReal;

	// When called from Mod
	public Compat_ItemEmptyMap() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ItemEmptyMap.class, this), null);
	}

	// When called from child
	protected Compat_ItemEmptyMap(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ItemEmptyMap(ItemEmptyMap original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_ItemEmptyMap thisReal, ItemEmptyMap original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public ItemEmptyMap getReal() {
		return original == null ? thisReal.get() : original;
	}
}
