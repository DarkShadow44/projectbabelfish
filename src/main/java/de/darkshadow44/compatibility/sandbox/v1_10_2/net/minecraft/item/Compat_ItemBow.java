package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.item;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.item.ItemBow;

public class Compat_ItemBow extends Compat_Item {
	private CompatI_ItemBow wrapper;

	// When called from Mod
	public Compat_ItemBow() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ItemBow.class, this));
	}

	// When called from child
	protected Compat_ItemBow(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ItemBow(ItemBow original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_ItemBow.class, original));
	}

	protected void initialize(CompatI_ItemBow wrapper) {
		this.wrapper = wrapper;
	}

	public ItemBow getReal() {
		return wrapper.get();
	}
}
