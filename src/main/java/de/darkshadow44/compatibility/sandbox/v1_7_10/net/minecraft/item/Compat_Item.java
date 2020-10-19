package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import java.util.ArrayList;
import java.util.List;

import de.darkshadow44.compatibility.autogen.Callback;
import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.texture.Compat_IIconRegister;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.creativetab.Compat_CreativeTabs;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.util.Compat_IIcon;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Compat_Item {
	private Item original;
	private CompatI_Item thisReal;

	// When called from Mod
	public Compat_Item() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Item.class, this), null);
	}

	// When called from child
	protected Compat_Item(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Item(Item original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_Item thisReal, Item original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public Item getReal() {
		return original == null ? thisReal.get() : original;
	}

	public Compat_Item Compat_func_77656_e(int maxDamage) {
		if (this.original == null)
			thisReal.setMaxDamageSuper(maxDamage);
		else
			original.setMaxDamage(maxDamage);
		return this;
	}

	public Compat_Item Compat_func_77625_d(int maxStackSize) {
		if (this.original == null)
			thisReal.setMaxStackSizeSuper(maxStackSize);
		else
			original.setMaxStackSize(maxStackSize);
		return this;
	}

	public Compat_Item Compat_func_77627_a(boolean hasSubtypes) {
		if (this.original == null)
			thisReal.setHasSubtypesSuper(hasSubtypes);
		else
			original.setHasSubtypes(hasSubtypes);
		return this;
	}

	public Compat_Item Compat_func_77637_a(Compat_CreativeTabs tab) {
		if (this.original == null)
			thisReal.setCreativeTabSuper(tab.getReal());
		else
			original.setCreativeTab(tab.getReal());
		return this;
	}

	public Compat_Item Compat_func_77655_b(String unlocalizedName) {
		if (this.original == null)
			thisReal.setUnlocalizedNameSuper(unlocalizedName);
		else
			original.setUnlocalizedName(unlocalizedName);
		return this;
	}

	private String iconString = null;

	public Compat_Item Compat_func_111206_d(String name) {
		iconString = name;
		return this;
	}

	@SideOnly(Side.CLIENT)
	protected String Compat_func_111208_A() { // getIconString
		return (this.iconString == null) ? ("MISSING_ICON_ITEM") : this.iconString;
	}

	public Compat_Item Compat_setNoRepair() {
		if (this.original == null)
			thisReal.setNoRepairSuper();
		else
			original.setNoRepair();
		return this;
	}

	public Compat_Item Compat_func_77664_n() {
		if (this.original == null)
			thisReal.setFull3DSuper();
		else
			original.setFull3D();
		return this;
	}

	public void Compat_set_field_77787_bX(boolean hasSubtypes) {
		if (this.original == null)
			thisReal.setHasSubtypesSuper(hasSubtypes);
		else
			original.setHasSubtypes(hasSubtypes);
	}

	public Compat_Item Compat_func_77642_a(Compat_Item containerItem) {
		if (this.original == null)
			thisReal.setContainerItemSuper(containerItem.getReal());
		else
			original.setContainerItem(containerItem.getReal());
		return this;
	}

	@SideOnly(Side.CLIENT)
	public void Compat_func_94581_a(Compat_IIconRegister iconRegister) {
		icon = iconRegister.Compat_func_94245_a(Compat_func_111208_A());
	}

	@SideOnly(Side.CLIENT)
	public Compat_IIcon Compat_func_77617_a(int damage) {
		// To be overriden
		return icon;
	}

	private Compat_IIcon icon;

	public void Compat_set_field_77791_bV(Compat_IIcon icon) {
		this.icon = icon;
	}

	public Compat_IIcon Compat_get_field_77791_bV() {
		return icon;
	}

	@Callback
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		List<Compat_ItemStack> itemsFake = new ArrayList<>();
		Compat_func_150895_a(this, new Compat_CreativeTabs(tab), itemsFake);
		for (Compat_ItemStack stack : itemsFake) {
			items.add(stack.getReal());
		}
	}

	public void Compat_func_150895_a(Compat_Item item, Compat_CreativeTabs tab, List<Compat_ItemStack> items) {
		NonNullList<ItemStack> realItems = NonNullList.create();
		if (this.original == null)
			thisReal.getSubItemsSuper(tab.getReal(), realItems);
		else
			original.getSubItems(tab.getReal(), realItems);
		for (ItemStack stack : realItems) {
			items.add(new Compat_ItemStack(stack));
		}
	}

	@Callback
	public String getItemStackDisplayName(ItemStack stack) {
		return Compat_func_77653_i(new Compat_ItemStack(stack));
	}

	public String Compat_func_77653_i(Compat_ItemStack itemstack) {
		if (this.original == null)
			return thisReal.getItemStackDisplayNameSuper(itemstack.getReal());
		else
			return original.getItemStackDisplayName(itemstack.getReal());
	}
}
