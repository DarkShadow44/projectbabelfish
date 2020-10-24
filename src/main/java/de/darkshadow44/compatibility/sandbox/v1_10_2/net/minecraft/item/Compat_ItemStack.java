package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.item;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.Compat_Block;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.nbt.Compat_NBTTagCompound;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

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
		NBTTagCompound tag;
		if (original == null)
			tag = thisReal.getTagCompoundSuper();
		else
			tag = original.getTagCompound();

		if (tag == null)
			return null;

		return new Compat_NBTTagCompound(tag);
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

	public boolean Compat_func_77942_o() {
		if (original == null)
			return thisReal.hasTagCompoundSuper();
		else
			return original.hasTagCompound();
	}

	public int Compat_get_field_77994_a() {
		if (original == null)
			return thisReal.getCountSuper();
		else
			return original.getCount();
	}

	public void Compat_set_field_77994_a(int value) {
		if (original == null)
			thisReal.setCountSuper(value);
		else
			original.setCount(value);
	}
}
