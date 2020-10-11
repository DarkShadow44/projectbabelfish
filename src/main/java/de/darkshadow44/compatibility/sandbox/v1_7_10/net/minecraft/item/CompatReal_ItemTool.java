package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import net.minecraft.item.ItemTool;

public class CompatReal_ItemTool extends ItemTool implements CompatI_ItemTool {
	@SuppressWarnings("unused")
	private Compat_ItemTool thisFake;

	public CompatReal_ItemTool(Compat_ItemTool thisFake) {
		super(null, null); // TODO
		this.thisFake = thisFake;
	}

	@Override
	public ItemTool get() {
		return this;
	}
}
