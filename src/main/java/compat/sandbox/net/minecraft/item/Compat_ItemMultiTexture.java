package compat.sandbox.net.minecraft.item;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.block.Compat_Block;
import net.minecraft.item.ItemMultiTexture;

public class Compat_ItemMultiTexture extends Compat_ItemBlock {
	private CompatI_ItemMultiTexture wrapper;

	private String[] field_150942_c = new String[0];

	// When called from Mod
	public Compat_ItemMultiTexture(Compat_Block block, Compat_Block block2, String[] par1) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ItemMultiTexture.class, this, block.getReal(), block2.getReal(), par1));
		field_150942_c = par1;
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

	public String[] Compat_get_field_150942_c() {
		return field_150942_c;
	}
}
