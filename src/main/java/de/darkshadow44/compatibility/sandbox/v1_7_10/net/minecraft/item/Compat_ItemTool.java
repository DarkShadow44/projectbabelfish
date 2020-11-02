package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
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
		this.wrapper = wrapper;
	}

	public ItemTool getReal() {
		return wrapper.get();
	}
}
