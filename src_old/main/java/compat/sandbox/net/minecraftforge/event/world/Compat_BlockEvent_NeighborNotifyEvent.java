package compat.sandbox.net.minecraftforge.event.world;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
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
