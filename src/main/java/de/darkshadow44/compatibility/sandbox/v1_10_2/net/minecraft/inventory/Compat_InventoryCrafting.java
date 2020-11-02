package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.inventory;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.inventory.InventoryCrafting;

public class Compat_InventoryCrafting {
	private CompatI_InventoryCrafting wrapper;

	// When called from Mod
	public Compat_InventoryCrafting() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_InventoryCrafting.class, this));
	}

	// When called from child
	protected Compat_InventoryCrafting(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_InventoryCrafting(InventoryCrafting original) {
		this.initialize(Factory.createWrapper(CompatI_InventoryCrafting.class, original));
	}

	protected void initialize(CompatI_InventoryCrafting wrapper) {
		this.wrapper = wrapper;
	}

	public InventoryCrafting getReal() {
		return wrapper.get();
	}
}
