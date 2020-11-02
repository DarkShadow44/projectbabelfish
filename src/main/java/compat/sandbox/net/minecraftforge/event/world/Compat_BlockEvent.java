package compat.sandbox.net.minecraftforge.event.world;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraftforge.fml.common.eventhandler.Compat_Event;
import net.minecraftforge.event.world.BlockEvent;

public class Compat_BlockEvent extends Compat_Event {
	private CompatI_BlockEvent wrapper;

	// When called from Mod
	public Compat_BlockEvent() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockEvent.class, this));
	}

	// When called from child
	protected Compat_BlockEvent(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockEvent(BlockEvent original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockEvent.class, original));
	}

	protected void initialize(CompatI_BlockEvent wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public BlockEvent getReal() {
		return wrapper.get();
	}
}
