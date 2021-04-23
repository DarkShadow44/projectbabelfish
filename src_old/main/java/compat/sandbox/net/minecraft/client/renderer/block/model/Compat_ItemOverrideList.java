package compat.sandbox.net.minecraft.client.renderer.block.model;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.client.renderer.block.model.ItemOverrideList;

public class Compat_ItemOverrideList {
	private CompatI_ItemOverrideList wrapper;

	private static Compat_ItemOverrideList NONE = new Compat_ItemOverrideList(ItemOverrideList.NONE);

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

	public static Compat_ItemOverrideList Compat_get_field_188022_a() {
		return NONE;
	}
}
