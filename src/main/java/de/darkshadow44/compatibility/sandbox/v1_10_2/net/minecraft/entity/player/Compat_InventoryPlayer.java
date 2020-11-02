package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.player;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.player.InventoryPlayer;

public class Compat_InventoryPlayer {
	private CompatI_InventoryPlayer wrapper;

	// When called from Mod
	public Compat_InventoryPlayer() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_InventoryPlayer.class, this));
	}

	// When called from child
	protected Compat_InventoryPlayer(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_InventoryPlayer(InventoryPlayer original) {
		this.initialize(Factory.createWrapper(CompatI_InventoryPlayer.class, original));
	}

	protected void initialize(CompatI_InventoryPlayer wrapper) {
		this.wrapper = wrapper;
	}

	public InventoryPlayer getReal() {
		return wrapper.get();
	}
}
