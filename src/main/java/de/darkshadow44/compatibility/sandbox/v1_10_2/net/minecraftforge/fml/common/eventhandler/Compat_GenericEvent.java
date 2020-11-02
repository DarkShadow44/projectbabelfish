package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.eventhandler;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraftforge.fml.common.eventhandler.GenericEvent;

public class Compat_GenericEvent<T> extends Compat_Event {
	private CompatI_GenericEvent<T> wrapper;

	// When called from Mod
	public Compat_GenericEvent() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_GenericEvent.class, this));
	}

	// When called from child
	protected Compat_GenericEvent(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_GenericEvent(GenericEvent<T> original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_GenericEvent.class, original));
	}

	protected void initialize(CompatI_GenericEvent<T> wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public GenericEvent<T> getReal() {
		return wrapper.get();
	}
}
