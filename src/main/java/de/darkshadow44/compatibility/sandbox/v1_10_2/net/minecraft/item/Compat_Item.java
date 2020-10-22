package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.item;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.creativetab.Compat_CreativeTabs;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.registry.Compat_IForgeRegistryEntry_Impl;
import net.minecraft.item.Item;

public class Compat_Item extends Compat_IForgeRegistryEntry_Impl<Item> {
	private Item original;
	private CompatI_Item thisReal;

	// When called from Mod
	public Compat_Item() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Item.class, this), null);
	}

	// When called from child
	protected Compat_Item(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_Item(Item original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_Item thisReal, Item original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public Item getReal() {
		return original == null ? thisReal.get() : original;
	}

	public Compat_Item Compat_func_77655_b(String name) {
		if (this.original == null)
			thisReal.setUnlocalizedNameSuper(name);
		else
			this.original.setUnlocalizedName(name);
		return this;
	}

	public Compat_Item Compat_func_77625_d(int size) {
		if (this.original == null)
			thisReal.setMaxStackSizeSuper(size);
		else
			this.original.setMaxStackSize(size);
		return this;
	}

	public Compat_Item Compat_func_77656_e(int damage) {
		if (this.original == null)
			thisReal.setMaxDamageSuper(damage);
		else
			this.original.setMaxDamage(damage);
		return this;
	}

	public Compat_Item Compat_func_77637_a(Compat_CreativeTabs tab) {
		if (this.original == null)
			thisReal.setCreativeTabSuper(tab.getReal());
		else
			this.original.setCreativeTab(tab.getReal());
		return this;
	}
}
