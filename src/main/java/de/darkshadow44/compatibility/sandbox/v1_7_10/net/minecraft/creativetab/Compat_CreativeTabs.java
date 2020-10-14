package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.creativetab;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item.Compat_ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public abstract class Compat_CreativeTabs {
	private CreativeTabs original;
	private CompatI_CreativeTabs thisReal;

	// When called from Mod
	public Compat_CreativeTabs(String label) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_CreativeTabs.class, this, label), null);
	}

	// When called from child
	protected Compat_CreativeTabs(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_CreativeTabs(CreativeTabs original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_CreativeTabs thisReal, CreativeTabs original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public CreativeTabs getReal() {
		return original == null ? thisReal.get() : original;
	}

	public abstract Compat_ItemStack Compat_func_151244_d();

	public ItemStack getTabIconItem() {
		return Compat_func_151244_d().getReal();
	}
}
