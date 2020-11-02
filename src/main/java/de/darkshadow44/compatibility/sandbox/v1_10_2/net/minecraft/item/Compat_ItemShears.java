package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.item;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
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
		this.wrapper = wrapper;
	}

	public ItemShears getReal() {
		return wrapper.get();
	}
}
