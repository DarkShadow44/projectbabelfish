package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.item;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.item.ItemPotion;

public class Compat_ItemPotion extends Compat_Item {
	private CompatI_ItemPotion wrapper;

	// When called from Mod
	public Compat_ItemPotion() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ItemPotion.class, this));
	}

	// When called from child
	protected Compat_ItemPotion(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ItemPotion(ItemPotion original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_ItemPotion.class, original));
	}

	protected void initialize(CompatI_ItemPotion wrapper) {
		this.wrapper = wrapper;
	}

	public ItemPotion getReal() {
		return wrapper.get();
	}
}
