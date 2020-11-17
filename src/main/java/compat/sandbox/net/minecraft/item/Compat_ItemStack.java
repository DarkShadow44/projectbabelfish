package compat.sandbox.net.minecraft.item;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.block.Compat_Block;
import compat.sandbox.net.minecraft.entity.Compat_EntityLivingBase;
import compat.sandbox.net.minecraft.nbt.Compat_NBTTagCompound;
import compat.sandbox.net.minecraft.util.Compat_EnumFacing;
import compat.sandbox.net.minecraftforge.common.capabilities.Compat_Capability;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;

public class Compat_ItemStack {
	private CompatI_ItemStack wrapper;

	// When called from Mod
	public Compat_ItemStack(Compat_Item item, int p1, int p2) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ItemStack.class, this, item.getReal(), p1, p2));
	}

	// When called from Mod
	public Compat_ItemStack(Compat_Block block) {
		this.initialize(Factory.create(CtorPos.POS2, CompatI_ItemStack.class, this, block.getReal()));
	}

	// When called from Mod
	public Compat_ItemStack(Compat_Item item) {
		this.initialize(Factory.create(CtorPos.POS3, CompatI_ItemStack.class, this, item.getReal()));
	}

	// When called from Mod
	public Compat_ItemStack(Compat_Block block, int p1, int p2) {
		this.initialize(Factory.create(CtorPos.POS4, CompatI_ItemStack.class, this, block.getReal(), p1, p2));
	}

	// When called from Mod
	public Compat_ItemStack(Compat_Item item, int p1) {
		this.initialize(Factory.create(CtorPos.POS5, CompatI_ItemStack.class, this, item.getReal(), p1));
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

	public void Compat_func_77982_d(Compat_NBTTagCompound nbt) {
		wrapper.setTagCompoundSuper(nbt.getReal());
	}

	public Compat_NBTTagCompound Compat_func_77978_p() {
		NBTTagCompound result = wrapper.getTagCompoundSuper();

		if (result == null)
			return null;

		return new Compat_NBTTagCompound(result);
	}

	public String Compat_func_82833_r() {
		return wrapper.getDisplayNameSuper();
	}

	public Compat_ItemStack Compat_func_151001_c(String name) {
		wrapper.setStackDisplayNameSuper(name);
		return this;
	}

	public int Compat_func_77952_i() {
		return wrapper.getItemDamageSuper();
	}

	public boolean Compat_func_77942_o() {
		return wrapper.hasTagCompoundSuper();
	}

	public int Compat_get_field_77994_a() {
		return wrapper.getCountSuper();
	}

	public void Compat_set_field_77994_a(int value) {
		wrapper.setCountSuper(value);
	}

	public Compat_Item Compat_func_77973_b() {
		Item result = wrapper.getItemSuper();
		return Compat_Item.get_fake(result);
	}

	public static Compat_ItemStack Compat_func_77949_a(Compat_NBTTagCompound tag) {
		if (tag.getReal().hasNoTags()) {
			return null;
		}

		ItemStack result = new ItemStack(tag.getReal());
		if (result.isEmpty())
			return null;

		return new Compat_ItemStack(result);
	}

	public Compat_ItemStack Compat_func_77946_l() {
		ItemStack result = wrapper.copySuper();
		return new Compat_ItemStack(result);
	}

	public int Compat_func_77960_j() {
		return wrapper.getMetadataSuper();
	}

	public Compat_NBTTagCompound Compat_func_77955_b(Compat_NBTTagCompound tag) {
		wrapper.writeToNBTSuper(tag.getReal());
		return tag;
	}

	public static Compat_ItemStack getFake(ItemStack stack) {
		if (stack instanceof CompatI_ItemStack) {
			return ((CompatI_ItemStack) stack).getFake();
		}
		return new Compat_ItemStack(stack);
	}

	public void Compat_func_77964_b(int damage) {
		wrapper.setItemDamageSuper(damage);
	}

	public boolean Compat_func_77969_a(Compat_ItemStack stack) {
		return wrapper.isItemEqualSuper(stack.getReal());
	}

	public void Compat_func_77972_a(int amount, Compat_EntityLivingBase entity) {
		wrapper.damageItemSuper(amount, entity.getReal());
	}

	public boolean Compat_hasCapability(Compat_Capability<?> capability, Compat_EnumFacing facing) {
		EnumFacing facing2 = facing == null ? null : facing.getReal();
		return wrapper.hasCapabilitySuper(capability.getReal(), facing2);
	}

	public Object Compat_getCapability(Compat_Capability<?> capability, Compat_EnumFacing facing) {
		EnumFacing facing2 = facing == null ? null : facing.getReal();
		return wrapper.getCapabilitySuper(capability.getReal(), facing2);
	}

}
