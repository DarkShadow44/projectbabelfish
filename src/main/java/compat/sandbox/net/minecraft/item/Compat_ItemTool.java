package compat.sandbox.net.minecraft.item;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.item.ItemTool;

public class Compat_ItemTool extends Compat_Item {
	private CompatI_ItemTool wrapper;

	// When called from Mod
	public Compat_ItemTool() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ItemTool.class, this));
	}

	// When called from child
	protected Compat_ItemTool(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ItemTool(ItemTool original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_ItemTool.class, original));
	}

	protected void initialize(CompatI_ItemTool wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public ItemTool getReal() {
		return wrapper.get();
	}
}
