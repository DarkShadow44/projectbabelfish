package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.item;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
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
		this.wrapper = wrapper;
	}

	public ItemSword getReal() {
		return wrapper.get();
	}
}
