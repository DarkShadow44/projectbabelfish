package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.eventhandler;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraftforge.fml.common.eventhandler.Event;

public class Compat_Event {
	private Event original;
	private CompatI_Event thisReal;

	// When called from Mod
	public Compat_Event() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Event.class, this), null);
	}

	// When called from child
	protected Compat_Event(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Event(Event original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_Event thisReal, Event original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public Event getReal() {
		return original == null ? thisReal.get() : original;
	}
}
