package compat.sandbox.net.minecraft.inventory;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.inventory.InventoryCraftResult;

public class Compat_InventoryCraftResult {
	private CompatI_InventoryCraftResult wrapper;

	// When called from Mod
	public Compat_InventoryCraftResult() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_InventoryCraftResult.class, this));
	}

	// When called from child
	protected Compat_InventoryCraftResult(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_InventoryCraftResult(InventoryCraftResult original) {
		this.initialize(Factory.createWrapper(CompatI_InventoryCraftResult.class, original));
	}

	protected void initialize(CompatI_InventoryCraftResult wrapper) {
		this.wrapper = wrapper;
	}

	public InventoryCraftResult getReal() {
		return wrapper.get();
	}
}
