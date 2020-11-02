package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.item;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.item.ItemEmptyMap;

public class Compat_ItemEmptyMap extends Compat_ItemMapBase {
	private CompatI_ItemEmptyMap wrapper;

	// When called from Mod
	public Compat_ItemEmptyMap() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ItemEmptyMap.class, this));
	}

	// When called from child
	protected Compat_ItemEmptyMap(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ItemEmptyMap(ItemEmptyMap original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_ItemEmptyMap.class, original));
	}

	protected void initialize(CompatI_ItemEmptyMap wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public ItemEmptyMap getReal() {
		return wrapper.get();
	}
}
