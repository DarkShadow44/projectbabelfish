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
	private CompatI_Item wrapper;

	// When called from Mod
	public Compat_Item() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Item.class, this));
	}

	// When called from child
	protected Compat_Item(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Item(Item original) {
		this.initialize(Factory.createWrapper(CompatI_Item.class, original));
	}

	protected void initialize(CompatI_Item wrapper) {
		this.wrapper = wrapper;
	}

	public Item getReal() {
		return wrapper.get();
	}

	public Compat_Item Compat_func_77656_e(int maxDamage) {
		
			wrapper.setMaxDamageSuper(maxDamage);
				return this;
	}

	public Compat_Item Compat_func_77625_d(int maxStackSize) {
		
			wrapper.setMaxStackSizeSuper(maxStackSize);
				return this;
	}

	public Compat_Item Compat_func_77627_a(boolean hasSubtypes) {
		
			wrapper.setHasSubtypesSuper(hasSubtypes);
				return this;
	}

	public Compat_Item Compat_func_77637_a(Compat_CreativeTabs tab) {
		
			wrapper.setCreativeTabSuper(tab.getReal());
				return this;
	}

	public Compat_Item Compat_func_77655_b(String unlocalizedName) {
		
			wrapper.setUnlocalizedNameSuper(unlocalizedName);
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
		
			wrapper.setNoRepairSuper();
				return this;
	}

	public Compat_Item Compat_func_77664_n() {
		
			wrapper.setFull3DSuper();
				return this;
	}

	public void Compat_set_field_77787_bX(boolean hasSubtypes) {
		
			wrapper.setHasSubtypesSuper(hasSubtypes);
			}

	public Compat_Item Compat_func_77642_a(Compat_Item containerItem) {
		
			wrapper.setContainerItemSuper(containerItem.getReal());
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
		
			wrapper.getSubItemsSuper(tab.getReal(), realItems);
				for (ItemStack stack : realItems) {
			items.add(new Compat_ItemStack(stack));
		}
	}

	@Callback
	public String getItemStackDisplayName(ItemStack stack) {
		return Compat_func_77653_i(new Compat_ItemStack(stack));
	}

	public String Compat_func_77653_i(Compat_ItemStack itemstack) {
		
			return wrapper.getItemStackDisplayNameSuper(itemstack.getReal());
			}

	@Callback
	public String getUnlocalizedName(ItemStack stack) {
		return Compat_func_77667_c(new Compat_ItemStack(stack));
	}

	public String Compat_func_77667_c(Compat_ItemStack stack) {
		
			return wrapper.getUnlocalizedNameSuper(stack.getReal());
			}

	public String Compat_func_77658_a() {
		
			return wrapper.getUnlocalizedNameSuper();
			}
}
