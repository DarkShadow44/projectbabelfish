package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.Compat_Block;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.nbt.Compat_NBTTagCompound;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class Compat_ItemStack {
	private CompatI_ItemStack wrapper;

	// When called from Mod
	public Compat_ItemStack(Compat_Item item) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ItemStack.class, this, item.getReal()));
	}

	// When called from Mod
	public Compat_ItemStack(Compat_Block block) {
		this.initialize(Factory.create(CtorPos.POS2, CompatI_ItemStack.class, this, block.getReal()));
	}

	// When called from Mod
	public Compat_ItemStack(Compat_Block block, int p1) {
		this.initialize(Factory.create(CtorPos.POS2, CompatI_ItemStack.class, this, block.getReal(), p1));
	}

	// When called from Mod
	public Compat_ItemStack(Compat_Block block, int amount, int meta) {
		this.initialize(Factory.create(CtorPos.POS3, CompatI_ItemStack.class, this, block.getReal(), amount, meta));
	}

	// When called from Mod
	public Compat_ItemStack(Compat_Item item, int p1, int p2) {
		this.initialize(Factory.create(CtorPos.POS4, CompatI_ItemStack.class, this, item.getReal(), p1, p2));
	}

	// When called from Mod
	public Compat_ItemStack(Compat_Item item, int p1) {
		this.initialize(Factory.create(CtorPos.POS4, CompatI_ItemStack.class, this, item.getReal(), p1));
	}

	// When called from child
	protected Compat_ItemStack(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_ItemStack(ItemStack original) {
		this.initialize(Factory.createWrapper(CompatI_ItemStack.class, original));
	}

	protected void initialize(CompatI_ItemStack wrapper) {
		this.wrapper = wrapper;
	}

	public ItemStack getReal() {
		return wrapper.get();
	}

	public Compat_ItemStack Compat_func_77946_l() {

		return new Compat_ItemStack(wrapper.copySuper());
	}

	public boolean Compat_func_77942_o() {

		return wrapper.hasTagCompoundSuper();
	}

	public int Compat_func_77960_j() {

		return wrapper.getItemDamageSuper();
	}

	public Compat_NBTTagCompound Compat_func_77978_p() {
		NBTTagCompound realTag;

		realTag = wrapper.getTagCompoundSuper();
		if (realTag == null) {
			return null;
		}
		return new Compat_NBTTagCompound(realTag);
	}
}
