package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.creativetab.Compat_CreativeTabs;
import net.minecraft.item.Item;

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

	public Compat_Item Compat_func_111206_d(String name) {
		// TODO setTextureName
		return this;
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
}
