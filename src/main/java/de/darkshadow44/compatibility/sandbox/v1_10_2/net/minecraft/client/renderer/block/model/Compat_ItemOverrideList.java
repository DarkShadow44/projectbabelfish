package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.model;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.renderer.block.model.ItemOverrideList;

public class Compat_ItemOverrideList {
	private ItemOverrideList original;
	private CompatI_ItemOverrideList thisReal;

	// When called from Mod
	public Compat_ItemOverrideList() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ItemOverrideList.class, this), null);
	}

	// When called from child
	protected Compat_ItemOverrideList(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_ItemOverrideList(ItemOverrideList original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_ItemOverrideList thisReal, ItemOverrideList original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public ItemOverrideList getReal() {
		return original == null ? thisReal.get() : original;
	}
}
