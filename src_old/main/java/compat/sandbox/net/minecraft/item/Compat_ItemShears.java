package compat.sandbox.net.minecraft.item;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.item.ItemShears;

public class Compat_ItemShears extends Compat_Item {
	private CompatI_ItemShears wrapper;

	// When called from Mod
	public Compat_ItemShears() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ItemShears.class, this));
	}

	// When called from child
	protected Compat_ItemShears(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ItemShears(ItemShears original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_ItemShears.class, original));
	}

	protected void initialize(CompatI_ItemShears wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public ItemShears getReal() {
		return wrapper.get();
	}
}
