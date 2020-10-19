package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.event;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.fml.common.eventhandler.Compat_GenericEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;

public class Compat_AttachCapabilitiesEvent<T> extends Compat_GenericEvent<T> {
	private AttachCapabilitiesEvent<T> original;
	private CompatI_AttachCapabilitiesEvent<T> thisReal;

	// When called from Mod
	public Compat_AttachCapabilitiesEvent() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_AttachCapabilitiesEvent.class, this), null);
	}

	// When called from child
	protected Compat_AttachCapabilitiesEvent(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_AttachCapabilitiesEvent(AttachCapabilitiesEvent<T> original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_AttachCapabilitiesEvent<T> thisReal, AttachCapabilitiesEvent<T> original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public AttachCapabilitiesEvent<T> getReal() {
		return original == null ? thisReal.get() : original;
	}
}
