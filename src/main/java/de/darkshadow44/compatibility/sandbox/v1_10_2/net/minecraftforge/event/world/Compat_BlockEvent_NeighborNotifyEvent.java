package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.event.world;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraftforge.event.world.BlockEvent.NeighborNotifyEvent;

public class Compat_BlockEvent_NeighborNotifyEvent extends Compat_BlockEvent {
	private CompatI_BlockEvent_NeighborNotifyEvent wrapper;

	// When called from Mod
	public Compat_BlockEvent_NeighborNotifyEvent() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockEvent_NeighborNotifyEvent.class, this));
	}

	// When called from child
	protected Compat_BlockEvent_NeighborNotifyEvent(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockEvent_NeighborNotifyEvent(NeighborNotifyEvent original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockEvent_NeighborNotifyEvent.class, original));
	}

	protected void initialize(CompatI_BlockEvent_NeighborNotifyEvent wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public NeighborNotifyEvent getReal() {
		return wrapper.get();
	}
}
