package compat.sandbox.net.minecraft.creativetab;

import compat.autogen.Callback;
import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.autogen.HasCallback;
import compat.core.ParentSelector;
import compat.core.Version;
import compat.sandbox.net.minecraft.item.Compat_Item;
import compat.sandbox.net.minecraft.item.Compat_ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class Compat_CreativeTabs {
	private CompatI_CreativeTabs wrapper;

	private Version version = Version.UNKNOWN;

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
		this.version = Version.get(this);
	}

	public CreativeTabs getReal() {
		return wrapper.get();
	}

	@Callback
	public ItemStack getTabIconItem() {
		switch (version) {
		case V1_10_2:
			return new ItemStack(Compat_func_78016_d().getReal(), 1, Compat_func_151243_f());
		case V1_7_10:
			return Compat_func_151244_d().getReal();
		default:
			throw version.makeException();
		}
	}

	@HasCallback({ Version.V1_10_2 , Version.V1_7_10 })
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

	@HasCallback({ Version.V1_10_2 })
	public int Compat_func_151243_f() { // getIconItemDamage
		return 0;
	}

	@HasCallback({ Version.V1_7_10 })
	public Compat_ItemStack Compat_func_151244_d() {
		return new Compat_ItemStack(new ItemStack(Compat_func_78016_d().getReal()));
	}

}
