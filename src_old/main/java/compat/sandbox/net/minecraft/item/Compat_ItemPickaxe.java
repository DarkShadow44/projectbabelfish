package compat.sandbox.net.minecraft.item;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.item.ItemPickaxe;

public class Compat_ItemPickaxe extends Compat_ItemTool {
	private CompatI_ItemPickaxe wrapper;

	// When called from Mod
	public Compat_ItemPickaxe(Compat_Item_ToolMaterial material) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ItemPickaxe.class, this, material.getReal()));
	}

	// When called from child
	protected Compat_ItemPickaxe(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ItemPickaxe(ItemPickaxe original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_ItemPickaxe.class, original));
	}

	protected void initialize(CompatI_ItemPickaxe wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public ItemPickaxe getReal() {
		return wrapper.get();
	}
}
