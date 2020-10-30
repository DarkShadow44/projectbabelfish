package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.player;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.player.InventoryPlayer;

public class Compat_InventoryPlayer {
	private InventoryPlayer original;
	private CompatI_InventoryPlayer thisReal;

	// When called from Mod
	public Compat_InventoryPlayer() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_InventoryPlayer.class, this), null);
	}

	// When called from child
	protected Compat_InventoryPlayer(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_InventoryPlayer(InventoryPlayer original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_InventoryPlayer thisReal, InventoryPlayer original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public InventoryPlayer getReal() {
		return original == null ? thisReal.get() : original;
	}
}
