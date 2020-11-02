package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.Compat_Block;
import net.minecraft.item.ItemSeeds;

public class Compat_ItemSeeds extends Compat_Item {
	private CompatI_ItemSeeds wrapper;

	// When called from Mod
	public Compat_ItemSeeds(Compat_Block b1, Compat_Block b2) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ItemSeeds.class, this, b1.getReal(), b2.getReal()));
	}

	// When called from child
	protected Compat_ItemSeeds(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ItemSeeds(ItemSeeds original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_ItemSeeds.class, original));
	}

	protected void initialize(CompatI_ItemSeeds wrapper) {
		this.wrapper = wrapper;
	}

	public ItemSeeds getReal() {
		return wrapper.get();
	}
}
