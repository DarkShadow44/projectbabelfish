package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.Compat_Block;
import net.minecraft.item.ItemStack;

public class Compat_ItemStack {
	private ItemStack original;
	private CompatI_ItemStack thisReal;

	// When called from Mod
	public Compat_ItemStack(Compat_Item item) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ItemStack.class, this, item.getReal()), null);
	}

	// When called from Mod
	public Compat_ItemStack(Compat_Block block) {
		this.initialize(Factory.create(CtorPos.POS2, CompatI_ItemStack.class, this, block.getReal()), null);
	}

	// When called from Mod
	public Compat_ItemStack(Compat_Block block, int p1) {
		this.initialize(Factory.create(CtorPos.POS2, CompatI_ItemStack.class, this, block.getReal(), p1), null);
	}

	// When called from Mod
	public Compat_ItemStack(Compat_Block block, int amount, int meta) {
		this.initialize(Factory.create(CtorPos.POS3, CompatI_ItemStack.class, this, block.getReal(), amount, meta), null);
	}

	// When called from Mod
	public Compat_ItemStack(Compat_Item item, int p1, int p2) {
		this.initialize(Factory.create(CtorPos.POS4, CompatI_ItemStack.class, this, item.getReal(), p1, p2), null);
	}

	// When called from Mod
	public Compat_ItemStack(Compat_Item item, int p1) {
		this.initialize(Factory.create(CtorPos.POS4, CompatI_ItemStack.class, this, item.getReal(), p1), null);
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

	public Compat_ItemStack Compat_func_77946_l() {
		if (this.original == null)
			return new Compat_ItemStack(thisReal.copySuper());
		else
			return new Compat_ItemStack(original.copy());
	}
}
