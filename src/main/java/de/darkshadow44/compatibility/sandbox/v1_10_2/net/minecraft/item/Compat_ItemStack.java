package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.item;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.Compat_Block;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.nbt.Compat_NBTTagCompound;
import net.minecraft.item.ItemStack;

public class Compat_ItemStack {
	private ItemStack original;
	private CompatI_ItemStack thisReal;

	// When called from Mod
	public Compat_ItemStack(Compat_Item item, int p1, int p2) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ItemStack.class, this, item.getReal(), p1, p2), null);
	}

	// When called from Mod
	public Compat_ItemStack(Compat_Block block) {
		this.initialize(Factory.create(CtorPos.POS2, CompatI_ItemStack.class, this, block.getReal()), null);
	}

	// When called from Mod
	public Compat_ItemStack(Compat_Item item) {
		this.initialize(Factory.create(CtorPos.POS3, CompatI_ItemStack.class, this, item.getReal()), null);
	}

	// When called from Mod
	public Compat_ItemStack(Compat_Block block, int p1, int p2) {
		this.initialize(Factory.create(CtorPos.POS4, CompatI_ItemStack.class, this, block.getReal(), p1, p2), null);
	}

	// When called from Mod
	public Compat_ItemStack(Compat_Item item, int p1) {
		this.initialize(Factory.create(CtorPos.POS5, CompatI_ItemStack.class, this, item.getReal(), p1), null);
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

	public void Compat_func_77982_d(Compat_NBTTagCompound nbt) {
		if (original == null)
			thisReal.setTagCompoundSuper(nbt.getReal());
		else
			original.setTagCompound(nbt.getReal());
	}

	public Compat_NBTTagCompound Compat_func_77978_p() {
		if (original == null)
			return new Compat_NBTTagCompound(thisReal.getTagCompoundSuper());
		else
			return new Compat_NBTTagCompound(original.getTagCompound());
	}

	public String Compat_func_82833_r() {
		if (original == null)
			return thisReal.getDisplayNameSuper();
		else
			return original.getDisplayName();
	}

	public Compat_ItemStack Compat_func_151001_c(String name) {
		if (original == null)
			thisReal.setStackDisplayNameSuper(name);
		else
			original.setStackDisplayName(name);
		return this;
	}

	public int Compat_func_77952_i() {
		if (original == null)
			return thisReal.getItemDamageSuper();
		else
			return original.getItemDamage();
	}
}
