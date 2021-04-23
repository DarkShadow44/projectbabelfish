package compat.sandbox.net.minecraftforge.client.event;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraftforge.fml.common.eventhandler.Compat_Event;
import net.minecraftforge.client.event.FOVUpdateEvent;

public class Compat_FOVUpdateEvent extends Compat_Event {
	private CompatI_FOVUpdateEvent wrapper;

	// When called from Mod
	public Compat_FOVUpdateEvent() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_FOVUpdateEvent.class, this));
	}

	// When called from child
	protected Compat_FOVUpdateEvent(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_FOVUpdateEvent(FOVUpdateEvent original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_FOVUpdateEvent.class, original));
	}

	protected void initialize(CompatI_FOVUpdateEvent wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public FOVUpdateEvent getReal() {
		return wrapper.get();
	}
}
