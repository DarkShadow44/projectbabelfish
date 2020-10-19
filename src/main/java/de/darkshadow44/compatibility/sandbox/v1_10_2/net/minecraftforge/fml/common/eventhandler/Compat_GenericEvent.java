package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.eventhandler;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraftforge.fml.common.eventhandler.GenericEvent;

public class Compat_GenericEvent<T> extends Compat_Event {
	private GenericEvent<T> original;
	private CompatI_GenericEvent<T> thisReal;

	// When called from Mod
	public Compat_GenericEvent() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_GenericEvent.class, this), null);
	}

	// When called from child
	protected Compat_GenericEvent(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_GenericEvent(GenericEvent<T> original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_GenericEvent<T> thisReal, GenericEvent<T> original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public GenericEvent<T> getReal() {
		return original == null ? thisReal.get() : original;
	}
}
