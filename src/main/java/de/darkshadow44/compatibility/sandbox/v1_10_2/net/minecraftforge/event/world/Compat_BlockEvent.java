package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.event.world;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.eventhandler.Compat_Event;
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
