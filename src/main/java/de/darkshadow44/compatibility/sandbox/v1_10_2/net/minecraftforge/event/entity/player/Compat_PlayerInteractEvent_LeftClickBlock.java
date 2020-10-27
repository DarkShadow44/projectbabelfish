package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.event.entity.player;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.LeftClickBlock;

public class Compat_PlayerInteractEvent_LeftClickBlock extends Compat_PlayerInteractEvent {
	private LeftClickBlock original;
	private CompatI_PlayerInteractEvent_LeftClickBlock thisReal;

	// When called from Mod
	public Compat_PlayerInteractEvent_LeftClickBlock() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_PlayerInteractEvent_LeftClickBlock.class, this), null);
	}

	// When called from child
	protected Compat_PlayerInteractEvent_LeftClickBlock(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_PlayerInteractEvent_LeftClickBlock(LeftClickBlock original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_PlayerInteractEvent_LeftClickBlock thisReal, LeftClickBlock original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public LeftClickBlock getReal() {
		return original == null ? thisReal.get() : original;
	}
}
