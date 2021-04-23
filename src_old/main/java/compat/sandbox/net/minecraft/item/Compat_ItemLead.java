package compat.sandbox.net.minecraft.item;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.item.ItemLead;

public class Compat_ItemLead extends Compat_Item {
	private CompatI_ItemLead wrapper;

	// When called from Mod
	public Compat_ItemLead() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ItemLead.class, this));
	}

	// When called from child
	protected Compat_ItemLead(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ItemLead(ItemLead original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_ItemLead.class, original));
	}

	protected void initialize(CompatI_ItemLead wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public ItemLead getReal() {
		return wrapper.get();
	}
}
