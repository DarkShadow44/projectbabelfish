package compat.sandbox.net.minecraft.item;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.item.ItemMultiTexture;

public class Compat_ItemMultiTexture extends Compat_ItemBlock {
	private CompatI_ItemMultiTexture wrapper;

	// When called from Mod
	public Compat_ItemMultiTexture() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ItemMultiTexture.class, this));
	}

	// When called from child
	protected Compat_ItemMultiTexture(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ItemMultiTexture(ItemMultiTexture original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_ItemMultiTexture.class, original));
	}

	protected void initialize(CompatI_ItemMultiTexture wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public ItemMultiTexture getReal() {
		return wrapper.get();
	}
}
