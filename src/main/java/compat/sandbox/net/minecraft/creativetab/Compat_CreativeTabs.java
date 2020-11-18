package compat.sandbox.net.minecraft.creativetab;

import compat.autogen.Callback;
import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.autogen.HasCallback;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.item.Compat_Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class Compat_CreativeTabs {
	private CompatI_CreativeTabs wrapper;

	// When called from Mod
	public Compat_CreativeTabs(String label) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_CreativeTabs.class, this, label));
	}

	// When called from child
	protected Compat_CreativeTabs(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_CreativeTabs(CreativeTabs original) {
		this.initialize(Factory.createWrapper(CompatI_CreativeTabs.class, original));
	}

	protected void initialize(CompatI_CreativeTabs wrapper) {
		this.wrapper = wrapper;
	}

	public CreativeTabs getReal() {
		return wrapper.get();
	}

	@Callback
	public ItemStack getTabIconItem() {
		return new ItemStack(Compat_func_78016_d().getReal(), 1, Compat_func_151243_f());
	}

	@HasCallback
	public Compat_Item Compat_func_78016_d() {
		// To be overridden
		return null;
	}

	public static Compat_CreativeTabs getFake(CreativeTabs tab) {
		if (tab instanceof CompatI_CreativeTabs) {
			return ((CompatI_CreativeTabs) tab).getFake();
		}
		return new Compat_CreativeTabs(tab);
	}


	@HasCallback
	public int Compat_func_151243_f() { // getIconItemDamage
		return 0;
	}

	/* TODO 1.7.10
	 * public Compat_ItemStack Compat_func_151244_d() {
		// Must be original, method is abstract
		return new Compat_ItemStack(wrapper.getIconItemStackSuper());
	}
	
	public ItemStack getTabIconItem() {
		return Compat_func_151244_d().getReal();
	}*/
}
