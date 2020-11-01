package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.event.world;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraftforge.event.world.BlockEvent.NeighborNotifyEvent;

public class Compat_BlockEvent_NeighborNotifyEvent extends Compat_BlockEvent {
	private NeighborNotifyEvent original;
	private CompatI_BlockEvent_NeighborNotifyEvent thisReal;

	// When called from Mod
	public Compat_BlockEvent_NeighborNotifyEvent() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockEvent_NeighborNotifyEvent.class, this), null);
	}

	// When called from child
	protected Compat_BlockEvent_NeighborNotifyEvent(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockEvent_NeighborNotifyEvent(NeighborNotifyEvent original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BlockEvent_NeighborNotifyEvent thisReal, NeighborNotifyEvent original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public NeighborNotifyEvent getReal() {
		return original == null ? thisReal.get() : original;
	}
}
