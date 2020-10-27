package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.event;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraftforge.event.AttachCapabilitiesEvent;

public class Compat_AttachCapabilitiesEvent_TileEntity<T> extends Compat_AttachCapabilitiesEvent<T> {
	private AttachCapabilitiesEvent<T> original;
	private CompatI_AttachCapabilitiesEvent_TileEntity<T> thisReal;

	// When called from Mod
	public Compat_AttachCapabilitiesEvent_TileEntity() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_AttachCapabilitiesEvent_TileEntity.class, this), null);
	}

	// When called from child
	protected Compat_AttachCapabilitiesEvent_TileEntity(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_AttachCapabilitiesEvent_TileEntity(AttachCapabilitiesEvent<T> original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_AttachCapabilitiesEvent_TileEntity<T> thisReal, AttachCapabilitiesEvent<T> original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public AttachCapabilitiesEvent<T> getReal() {
		return original == null ? thisReal.get() : original;
	}
}
