package compat.sandbox.net.minecraftforge.fml.common.eventhandler;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraftforge.fml.common.eventhandler.Event;

public class Compat_Event {
	private CompatI_Event wrapper;

	// When called from Mod
	public Compat_Event() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Event.class, this));
	}

	// When called from child
	protected Compat_Event(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Event(Event original) {
		this.initialize(Factory.createWrapper(CompatI_Event.class, original));
	}

	protected void initialize(CompatI_Event wrapper) {
		this.wrapper = wrapper;
	}

	public Event getReal() {
		return wrapper.get();
	}
}
