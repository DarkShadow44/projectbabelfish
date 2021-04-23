package compat.sandbox.net.minecraft.item;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.item.ItemDye;

public class Compat_ItemDye extends Compat_Item {
	private CompatI_ItemDye wrapper;

	// When called from Mod
	public Compat_ItemDye() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ItemDye.class, this));
	}

	// When called from child
	protected Compat_ItemDye(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ItemDye(ItemDye original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_ItemDye.class, original));
	}

	protected void initialize(CompatI_ItemDye wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public ItemDye getReal() {
		return wrapper.get();
	}

	public static String[] Compat_get_field_150921_b() {
		return new String[] { "black", "red", "green", "brown", "blue", "purple", "cyan", "silver", "gray", "pink", "lime", "yellow", "light_blue", "magenta", "orange", "white" };
	}
}
