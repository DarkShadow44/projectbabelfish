package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.model;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.renderer.block.model.ItemOverrideList;

public class Compat_ItemOverrideList {
	private CompatI_ItemOverrideList wrapper;

	// When called from Mod
	public Compat_ItemOverrideList() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ItemOverrideList.class, this));
	}

	// When called from child
	protected Compat_ItemOverrideList(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_ItemOverrideList(ItemOverrideList original) {
		this.initialize(Factory.createWrapper(CompatI_ItemOverrideList.class, original));
	}

	protected void initialize(CompatI_ItemOverrideList wrapper) {
		this.wrapper = wrapper;
	}

	public ItemOverrideList getReal() {
		return wrapper.get();
	}
}
