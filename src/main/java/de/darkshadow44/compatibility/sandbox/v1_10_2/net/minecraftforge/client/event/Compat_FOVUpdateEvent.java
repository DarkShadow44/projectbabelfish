package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.client.event;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.eventhandler.Compat_Event;
import net.minecraftforge.client.event.FOVUpdateEvent;

public class Compat_FOVUpdateEvent extends Compat_Event {
	private FOVUpdateEvent original;
	private CompatI_FOVUpdateEvent thisReal;

	// When called from Mod
	public Compat_FOVUpdateEvent() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_FOVUpdateEvent.class, this), null);
	}

	// When called from child
	protected Compat_FOVUpdateEvent(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_FOVUpdateEvent(FOVUpdateEvent original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_FOVUpdateEvent thisReal, FOVUpdateEvent original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public FOVUpdateEvent getReal() {
		return original == null ? thisReal.get() : original;
	}
}
