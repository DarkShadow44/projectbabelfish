package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
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
		this.wrapper = wrapper;
	}

	public ItemPickaxe getReal() {
		return wrapper.get();
	}
}
