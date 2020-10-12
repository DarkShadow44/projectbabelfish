package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.item.ItemStack;

public class Compat_ItemStack {
	private ItemStack original;
	private CompatI_ItemStack thisReal;

	// When called from Mod
	public Compat_ItemStack(Compat_Item item) {
		this.initialize(Factory.create(CtorPos.POS1, this, item.getReal()), null);
	}

	// When called from child
	protected Compat_ItemStack(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_ItemStack(ItemStack original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_ItemStack thisReal, ItemStack original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public ItemStack getReal() {
		return original == null ? thisReal.get() : original;
	}
}
