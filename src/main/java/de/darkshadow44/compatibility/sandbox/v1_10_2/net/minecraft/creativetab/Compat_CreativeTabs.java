package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.creativetab;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.item.Compat_Item;
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

	public ItemStack getTabIconItem() {
		return new ItemStack(Compat_func_78016_d().getReal());
	}

	public Compat_Item Compat_func_78016_d() {
		// To be overriden
		return null;
	}
}
