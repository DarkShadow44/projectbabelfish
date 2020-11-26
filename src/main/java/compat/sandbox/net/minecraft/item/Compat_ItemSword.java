package compat.sandbox.net.minecraft.item;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.item.ItemSword;

public class Compat_ItemSword extends Compat_Item {
	private CompatI_ItemSword wrapper;

	// When called from Mod
	public Compat_ItemSword(Compat_Item_ToolMaterial material) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ItemSword.class, this, material.getReal()));
	}

	// When called from child
	protected Compat_ItemSword(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ItemSword(ItemSword original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_ItemSword.class, original));
	}

	protected void initialize(CompatI_ItemSword wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public ItemSword getReal() {
		return wrapper.get();
	}
}
