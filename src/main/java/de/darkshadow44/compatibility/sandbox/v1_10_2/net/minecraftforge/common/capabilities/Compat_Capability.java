package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.common.capabilities;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraftforge.common.capabilities.Capability;

public class Compat_Capability {
	private Capability<?> original;
	private CompatI_Capability thisReal;

	// When called from Mod
	public Compat_Capability() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Capability.class, this), null);
	}

	// When called from child
	protected Compat_Capability(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Capability(Capability<?> original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_Capability thisReal, Capability<?> original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public Capability<?> getReal() {
		return original == null ? thisReal.get() : original;
	}
}
